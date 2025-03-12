package io.github.nathensample.craftsman.pricehistory.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import io.github.nathensample.craftsman.configuration.Configuration;
import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleSheetDownloaderService {

    @Autowired
    private Configuration configuration;

    @Autowired
    private MarketHistoryLookupTable marketHistoryLookupTable;

    private static final GsonFactory GSON_FACTORY = GsonFactory.getDefaultInstance();

    public GoogleSheetDownloaderService(Configuration configuration, MarketHistoryLookupTable marketHistoryLookupTable) {
        this.configuration = configuration;
        this.marketHistoryLookupTable = marketHistoryLookupTable;
    }

    @PostConstruct
    public void init() throws GeneralSecurityException, IOException {
        // Build Sheets API service (no authentication needed)
        Sheets sheetsService = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GSON_FACTORY,
                null // No credentials required for public access
        ).setApplicationName(configuration.getApplicationName()).build();

        List<List<Object>> values = fetchDataFromGSheets(sheetsService);
        extractAndPublishMarketHistory(values);
    }

    void extractAndPublishMarketHistory(List<List<Object>> values)
    {
        List<ItemMarketHistory> itemMarketHistories = new ArrayList<>();

        for (List<Object> row : values) {
            // Ensure there are enough columns in the row
            if (row.size() >= 8) {
                Integer itemId = Integer.valueOf((String) row.get(0));
                String itemName = (String) row.get(1);

                // Handle conversion of data to BigDecimal and int
                BigDecimal oneDayAveragePrice = sanitizeBigDecimal(row.get(2).toString());
                BigDecimal oneDayHourVolume = sanitizeBigDecimal(row.get(3).toString());

                BigDecimal sevenDayAveragePrice = sanitizeBigDecimal(row.get(4).toString());
                BigDecimal sevenDayVolume = sanitizeBigDecimal(row.get(5).toString());

                BigDecimal thirtyAveragePrice = sanitizeBigDecimal(row.get(6).toString());
                BigDecimal thirtyDayVolume = sanitizeBigDecimal(row.get(7).toString());

                // Create a new ItemPriceHistory object
                ItemMarketHistory itemMarketHistory = new ItemMarketHistory(
                        itemId,
                        itemName,
                        oneDayAveragePrice,
                        oneDayHourVolume,
                        sevenDayAveragePrice,
                        sevenDayVolume,
                        thirtyAveragePrice,
                        thirtyDayVolume
                );

                itemMarketHistories.add(itemMarketHistory);
            }
        }

        marketHistoryLookupTable.publishHistory(itemMarketHistories);
    }

    private BigDecimal sanitizeBigDecimal(String inputStr)
    {
        inputStr = inputStr.replace("g", "");
        return inputStr.isEmpty()
                ? BigDecimal.ZERO
                : new BigDecimal(inputStr);
    }


    private List<List<Object>> fetchDataFromGSheets(Sheets sheetsService) throws GeneralSecurityException, IOException {
            // Public Spreadsheet ID and Range
            String spreadsheetId = configuration.getSpreadsheetId();
            String range = configuration.getSpreadsheetRange();

            // Fetch data
            ValueRange response = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .setKey(configuration.getGcpApiKey())
                    .execute();

        return response.getValues();
    }
}

