package io.github.nathensample.craftsman.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nathensample.craftsman.items.Item;
import io.github.nathensample.craftsman.items.ItemLookupTable;
import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import io.github.nathensample.craftsman.pricehistory.service.MarketHistoryLookupTable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller()
public class getItemMarketHistoryController {
    @Autowired
    private Logger logger;

    @Autowired
    private MarketHistoryLookupTable marketHistoryLookupTable;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GetMapping("/market-history")
    //TODO: Properly handle this exception
    public ResponseEntity<String> getItemHistory(@RequestParam String itemName) throws JsonProcessingException {
        Optional<ItemMarketHistory> itemOpt = marketHistoryLookupTable.getItem(itemName);

        if (itemOpt.isPresent()) {
            String json = OBJECT_MAPPER.writeValueAsString(itemOpt.get());
            return ResponseEntity.ok(json);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Item Name [%s] not found in history lookup.", itemName));
    }
}
