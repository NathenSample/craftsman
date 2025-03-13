package io.github.nathensample.craftsman.pricehistory.service;

import io.github.nathensample.craftsman.craftingreqs.model.Item;
import io.github.nathensample.craftsman.pricehistory.model.PriceCalculationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PriceCalculationService {

    @Autowired
    private MarketHistoryLookupTable marketHistoryLookupTable;

    public PriceCalculationService(MarketHistoryLookupTable marketHistoryLookupTable) {
        this.marketHistoryLookupTable = marketHistoryLookupTable;
    }

    public PriceCalculationResponse getPriceCalculation(Map<Item, Integer> itemQuantityMap, PriceCalculationPeriod period){
        return null;
    }
}
