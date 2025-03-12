package io.github.nathensample.craftsman.pricehistory.service;

import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MarketHistoryLookupTable {
    private List<ItemMarketHistory> itemMarketHistories = Collections.unmodifiableList(new ArrayList<>());

    public List<ItemMarketHistory> getItemMarketHistories() {
        return itemMarketHistories;
    }

    public void publishHistory(List<ItemMarketHistory> itemMarketHistories) {
        this.itemMarketHistories = Collections.unmodifiableList(itemMarketHistories);
    }


}
