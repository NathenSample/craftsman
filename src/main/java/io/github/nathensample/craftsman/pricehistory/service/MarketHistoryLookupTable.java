package io.github.nathensample.craftsman.pricehistory.service;

import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Name;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MarketHistoryLookupTable {

    private Map<Integer, ItemMarketHistory> idToHistoryMap = Map.of();
    private Map<String, ItemMarketHistory> nameToHistoryMap = Map.of();

    public void publishHistory(List<ItemMarketHistory> itemMarketHistories) {
        Map<Integer, ItemMarketHistory> mutableIdMap = itemMarketHistories.stream()
                .collect(Collectors.toMap(ItemMarketHistory::getItemId, item -> item));
        idToHistoryMap = Collections.unmodifiableMap(mutableIdMap);

        Map<String, ItemMarketHistory> mutableNameMap = itemMarketHistories.stream()
                .collect(Collectors.toMap(
                        ItemMarketHistory::getItemName,  // Key is itemName
                        item -> item,                    // Value is the item itself
                        ItemMarketHistory::compareAndSelect  // Merge function to resolve duplicates
                ));
        nameToHistoryMap = Collections.unmodifiableMap(mutableNameMap);
    }

    public Optional<ItemMarketHistory> getItem(String itemName)
    {
        return Optional.ofNullable(nameToHistoryMap.get(itemName));
    }

}
