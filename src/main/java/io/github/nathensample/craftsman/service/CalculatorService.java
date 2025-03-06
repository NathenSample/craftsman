package io.github.nathensample.craftsman.service;

import io.github.nathensample.craftsman.items.ItemLookupTableHandler;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    @Autowired
    private ItemLookupTableHandler itemStore;

    public CalculatorService() {
    }

    @PostConstruct
    public void postconstruct() {

    }
}
