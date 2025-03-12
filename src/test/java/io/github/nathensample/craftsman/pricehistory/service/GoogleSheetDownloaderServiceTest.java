package io.github.nathensample.craftsman.pricehistory.service;

import com.google.api.services.sheets.v4.Sheets;
import io.github.nathensample.craftsman.configuration.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GoogleSheetDownloaderServiceTest {


    @Mock
    private Configuration configuration;

    @Mock
    private MarketHistoryLookupTable marketHistoryLookupTable;

    private GoogleSheetDownloaderService googleSheetDownloaderService;

    @BeforeEach
    void setUp() {
        // Manually instantiate the service to avoid triggering @PostConstruct
        googleSheetDownloaderService = new GoogleSheetDownloaderService(configuration, marketHistoryLookupTable);
    }
    @Test
    void extractAndPublishMarketHistory() {
        // Sample response from Google Sheets API (List of rows)
        List<List<Object>> values = new ArrayList<>();

        // Add your sample rows here
        values.add(List.of(98, "Decorative Vase", "", "", "", "", 2.23, 1));
        values.add(List.of(99, "Lucky Azalea Vase", "", "", 7, 1, 7.75, 4));
        values.add(List.of(100, "Ebony Bonsai Flowerpot", "", "", 6.25, 1, 5.708333333, 6));

        googleSheetDownloaderService.extractAndPublishMarketHistory(values);
        verify(marketHistoryLookupTable).publishHistory(argThat(list -> list.size() == 3));
    }
}