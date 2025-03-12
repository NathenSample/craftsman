package io.github.nathensample.craftsman.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import io.github.nathensample.craftsman.pricehistory.service.MarketHistoryLookupTable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class getItemMarketHistoryController {
    @Autowired
    private Logger logger;

    @Autowired
    private MarketHistoryLookupTable marketHistoryLookupTable;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GetMapping("/market-history")
    public ResponseEntity<String> getItemHistoryByName(@RequestParam(required = false) String itemName,
                                                       @RequestParam(required = false) Integer itemId) throws JsonProcessingException {
        if (itemName != null) {
            // Handle by name
            Optional<ItemMarketHistory> itemOpt = marketHistoryLookupTable.getItem(itemName);
            if (itemOpt.isPresent()) {
                String json = OBJECT_MAPPER.writeValueAsString(itemOpt.get());
                return ResponseEntity.ok(json);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Item Name [%s] not found in history lookup.", itemName));
        } else if (itemId != null) {
            // Handle by ID
            Optional<ItemMarketHistory> itemOpt = marketHistoryLookupTable.getItem(itemId);
            if (itemOpt.isPresent()) {
                String json = OBJECT_MAPPER.writeValueAsString(itemOpt.get());
                return ResponseEntity.ok(json);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Item Id [%s] not found in history lookup.", itemId));
        }
        return ResponseEntity.badRequest().body("Please provide either itemName or itemId.");
    }
}
