package io.github.nathensample.craftsman.service;

import io.github.nathensample.craftsman.items.Item;
import io.github.nathensample.craftsman.items.ItemStore;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    @Autowired
    private ItemStore itemStore;

    public CalculatorService()
    {
    }

    @PostConstruct
    public void postconstruct()
    {

    }
}
