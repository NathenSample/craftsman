package io.github.nathensample.craftsman.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class getItemController {

    @GetMapping("/itemSearch")
    public ResponseEntity<String> getItemRecipe(@RequestParam String itemName)
    {
        //TODO: Stub
        return null;
    }
}
