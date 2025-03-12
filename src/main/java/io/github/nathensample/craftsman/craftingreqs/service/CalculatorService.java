package io.github.nathensample.craftsman.craftingreqs.service;

import io.github.nathensample.craftsman.craftingreqs.items.ItemLookupTable;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    @Autowired
    private ItemLookupTable itemStore;

    public CalculatorService() {
    }

    @PostConstruct
    public void postconstruct() {

    }
}
