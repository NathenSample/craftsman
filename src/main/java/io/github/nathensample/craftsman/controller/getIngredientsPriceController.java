package io.github.nathensample.craftsman.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nathensample.craftsman.craftingreqs.model.Item;
import io.github.nathensample.craftsman.craftingreqs.model.ItemLookupTable;
import io.github.nathensample.craftsman.pricehistory.model.PriceCalculationWrapper;
import io.github.nathensample.craftsman.pricehistory.service.PriceCalculationPeriod;
import io.github.nathensample.craftsman.pricehistory.service.PriceCalculationService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController

public class getIngredientsPriceController {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private Logger logger;
    @Autowired
    private PriceCalculationService priceCalculationService;

    @Autowired
    private ItemLookupTable itemLookupTable;

    @GetMapping("/ingredients-price")
    public ResponseEntity<String> getIngredientPriceForName(@RequestParam String itemName) throws JsonProcessingException {
        Optional<Item> itemOpt = itemLookupTable.getItem(itemName);
        if (itemOpt.isPresent()) {
            Map<Item, Integer> itemToQuantity = itemOpt.get().computeRequirements();
            String json = OBJECT_MAPPER.writeValueAsString(new PriceCalculationWrapper(itemName, priceCalculationService.getPriceCalculation(itemToQuantity, PriceCalculationPeriod.SEVEN_DAY)));
            return ResponseEntity.ok(json);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Item Name [%s] not found in recipe lookup.", itemName));

    }
}
