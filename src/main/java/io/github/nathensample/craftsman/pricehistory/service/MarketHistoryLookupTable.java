package io.github.nathensample.craftsman.pricehistory.service;

import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketHistoryLookupTable {

    @Autowired
    private Logger logger;

    private Map<Integer, ItemMarketHistory> idToHistoryMap = Map.of();
    private Map<String, ItemMarketHistory> nameToHistoryMap = Map.of();

    public void publishHistory(List<ItemMarketHistory> itemMarketHistories) {
        Map<Integer, ItemMarketHistory> mutableIdMap = itemMarketHistories.stream()
                .collect(Collectors.toMap(ItemMarketHistory::getItemId, item -> item));
        idToHistoryMap = Collections.unmodifiableMap(mutableIdMap);

        Map<String, ItemMarketHistory> mutableNameMap = itemMarketHistories.stream()
                .collect(Collectors.toMap(
                        ItemMarketHistory::getItemNameToLower,  // Key is itemName
                        item -> item,                    // Value is the item itself
                        ItemMarketHistory::compareAndSelect  // Merge function to resolve duplicates
                ));
        nameToHistoryMap = Collections.unmodifiableMap(mutableNameMap);

        logger.info("HistoryStore initialized. [{}] items in map.", nameToHistoryMap.size());
    }

    public Optional<ItemMarketHistory> getItem(String itemName) {
        return Optional.ofNullable(nameToHistoryMap.get(itemName));
    }

    public Optional<ItemMarketHistory> getItem(Integer itemId) {
        return Optional.ofNullable(idToHistoryMap.get(itemId));
    }

}
