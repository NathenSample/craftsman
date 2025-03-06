package io.github.nathensample.craftsman.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nathensample.craftsman.items.Item;
import io.github.nathensample.craftsman.items.ItemLookupTableHandler;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller()
@RequestMapping("/ingredients")
public class getItemIngredientsController {

    @Autowired
    private Logger logger;

    @Autowired
    private ItemLookupTableHandler itemLookupTableHandler;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GetMapping("/searchByName/{itemName}")
    //TODO: Properly handle this exception
    public ResponseEntity<String> getItemRecipe(@PathVariable String itemName) throws JsonProcessingException {
        Optional<Item> itemOpt = itemLookupTableHandler.getItem(itemName);

        if (itemOpt.isPresent()) {
            String json = OBJECT_MAPPER.writeValueAsString(itemOpt.get().computeRequirements());
            return ResponseEntity.ok(json);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Item Name [%s] not found in lookup.", itemName));
    }
}
