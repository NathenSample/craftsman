package io.github.nathensample.craftsman.pricehistory.service;

import io.github.nathensample.craftsman.craftingreqs.model.Item;
import io.github.nathensample.craftsman.pricehistory.model.ItemMarketHistory;
import io.github.nathensample.craftsman.pricehistory.model.PriceCalculationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceCalculationServiceTest {

    private MarketHistoryLookupTable marketHistoryLookupTableMock;

    private PriceCalculationService priceCalculationService;

    @BeforeEach
    void setup()
    {
        MockitoAnnotations.openMocks(this);
        marketHistoryLookupTableMock = mock(MarketHistoryLookupTable.class);
        priceCalculationService = new PriceCalculationService(marketHistoryLookupTableMock);
    }

    @Test
    public void testGetPriceCalculation()
    {
        Item mockItem1 = mock(Item.class);
        when(mockItem1.getName()).thenReturn("Test1");
        Item mockItem2 = mock(Item.class);
        when(mockItem2.getName()).thenReturn("Test2");
        Item mockItem3 = mock(Item.class);
        when(mockItem3.getName()).thenReturn("Test3");

        ItemMarketHistory itemMarketHistory1 = new ItemMarketHistory(1, "Test1", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ZERO);
        ItemMarketHistory itemMarketHistory2 = new ItemMarketHistory(1, "Test2", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ZERO);
        ItemMarketHistory itemMarketHistory3 = new ItemMarketHistory(1, "Test3", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ZERO);

        when(marketHistoryLookupTableMock.getItem("Test1")).thenReturn(Optional.of(itemMarketHistory1));
        when(marketHistoryLookupTableMock.getItem("Test2")).thenReturn(Optional.of(itemMarketHistory2));
        when(marketHistoryLookupTableMock.getItem("Test3")).thenReturn(Optional.of(itemMarketHistory3));

        PriceCalculationResponse priceCalculationResponse = priceCalculationService.getPriceCalculation(Map.of(mockItem1, 1, mockItem2, 2, mockItem3, 3), PriceCalculationPeriod.ONE_DAY);

        assertEquals(6, priceCalculationResponse.price().intValue());
    }

    @Test
    public void testGetPriceWithMissingItem()
    {
        Item mockItem1 = mock(Item.class);
        when(mockItem1.getName()).thenReturn("Test1");
        Item mockItem2 = mock(Item.class);
        when(mockItem2.getName()).thenReturn("Test2");
        Item mockItem3 = mock(Item.class);
        when(mockItem3.getName()).thenReturn("Test3");

        ItemMarketHistory itemMarketHistory1 = new ItemMarketHistory(1, "Test1", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ZERO);
        ItemMarketHistory itemMarketHistory2 = new ItemMarketHistory(1, "Test2", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ZERO);

        when(marketHistoryLookupTableMock.getItem("Test1")).thenReturn(Optional.of(itemMarketHistory1));
        when(marketHistoryLookupTableMock.getItem("Test2")).thenReturn(Optional.of(itemMarketHistory2));
        when(marketHistoryLookupTableMock.getItem("Test3")).thenReturn(Optional.empty());

        PriceCalculationResponse priceCalculationResponse = priceCalculationService.getPriceCalculation(Map.of(mockItem1, 1, mockItem2, 2, mockItem3, 3), PriceCalculationPeriod.ONE_DAY);

        assertEquals(3, priceCalculationResponse.price().intValue());
        assertEquals(1, priceCalculationResponse.unpricedItemNames().size());
        assertEquals("Test3", priceCalculationResponse.unpricedItemNames().get(0));
    }
}