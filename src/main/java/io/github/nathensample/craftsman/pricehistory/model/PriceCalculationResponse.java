package io.github.nathensample.craftsman.pricehistory.model;

import java.math.BigDecimal;
import java.util.List;

public record PriceCalculationResponse(BigDecimal price, List<String> unpricedItemNames) {

}
