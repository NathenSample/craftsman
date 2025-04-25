package io.github.nathensample.craftsman.pricehistory.service;

import io.github.nathensample.craftsman.craftingreqs.model.Item;
import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import io.github.nathensample.craftsman.pricehistory.model.PriceCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PriceCalculationService {

    @Autowired
    private MarketHistoryLookupTable marketHistoryLookupTable;

    public PriceCalculationService(MarketHistoryLookupTable marketHistoryLookupTable) {
        this.marketHistoryLookupTable = marketHistoryLookupTable;
    }

    public PriceCalculation getPriceCalculation(Map<Item, Integer> itemQuantityMap, PriceCalculationPeriod period){
        List<String> unpricedItemNames = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Item, Integer> entry : itemQuantityMap.entrySet()) {
            int quantity = entry.getValue();
            String itemName = entry.getKey().getName();

            Optional<ItemMarketHistory> itemMarketHistoryOpt = marketHistoryLookupTable.getItem(itemName.toLowerCase());
            if (itemMarketHistoryOpt.isPresent())
            {
                ItemMarketHistory itemMarketHistory = itemMarketHistoryOpt.get();
                BigDecimal priceInPeriod = itemMarketHistory.getAveragePrice(period);
                if (priceInPeriod.equals(BigDecimal.ZERO))
                {
                    unpricedItemNames.add(itemName);
                }
                total = total.add(priceInPeriod.multiply(BigDecimal.valueOf(quantity)));
            } else {
                unpricedItemNames.add(itemName);
            }
        };

        return new PriceCalculation(total, unpricedItemNames);
    }
}
