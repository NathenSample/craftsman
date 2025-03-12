package io.github.nathensample.craftsman.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nathensample.craftsman.craftingreqs.model.Item;
import io.github.nathensample.craftsman.craftingreqs.model.ItemLookupTable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller()
public class getItemIngredientsController {

    @Autowired
    private Logger logger;

    @Autowired
    private ItemLookupTable itemLookupTable;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GetMapping("/crafting-requirements")
    //TODO: Properly handle this exception
    public ResponseEntity<String> getItemRecipe(@RequestParam String itemName) throws JsonProcessingException {
        Optional<Item> itemOpt = itemLookupTable.getItem(itemName);

        if (itemOpt.isPresent()) {
            String json = OBJECT_MAPPER.writeValueAsString(itemOpt.get().computeRequirements());
            return ResponseEntity.ok(json);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Item Name [%s] not found in lookup.", itemName));
    }
}
