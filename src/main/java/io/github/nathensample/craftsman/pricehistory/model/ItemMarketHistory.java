package io.github.nathensample.craftsman.pricehistory.model;

import io.github.nathensample.craftsman.pricehistory.service.PriceCalculationPeriod;

import java.math.BigDecimal;

public class ItemMarketHistory {
    private final Integer itemId;
    private final String itemName;
    private final BigDecimal oneDayAveragePrice;
    private final BigDecimal oneDayHourVolume;
    private final BigDecimal sevenDayAveragePrice;
    private final BigDecimal sevenDayVolume;
    private final BigDecimal thirtyAveragePrice;
    private final BigDecimal thirtyDayVolume;

    public ItemMarketHistory(Integer itemId, String itemName, BigDecimal oneDayAveragePrice, BigDecimal oneDayHourVolume, BigDecimal sevenDayAveragePrice, BigDecimal sevenDayVolume, BigDecimal thirtyAveragePrice, BigDecimal thirtyDayVolume) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.oneDayAveragePrice = oneDayAveragePrice;
        this.oneDayHourVolume = oneDayHourVolume;
        this.sevenDayAveragePrice = sevenDayAveragePrice;
        this.sevenDayVolume = sevenDayVolume;
        this.thirtyAveragePrice = thirtyAveragePrice;
        this.thirtyDayVolume = thirtyDayVolume;
    }

    public static ItemMarketHistory compareAndSelect(ItemMarketHistory obj1, ItemMarketHistory obj2) {
        int countObj1 = countNonDefaultFields(obj1);
        int countObj2 = countNonDefaultFields(obj2);

        // Return the object with more non-default fields
        if (countObj1 > countObj2) {
            return obj1;
        } else if (countObj2 > countObj1) {
            return obj2;
        } else {
            // If both have the same number of non-default fields, you can return either or handle as needed
            return obj1; // Or obj2, based on your requirement
        }
    }

    // Helper method to count the number of non-default fields in an ItemMarketHistory object
    private static int countNonDefaultFields(ItemMarketHistory obj) {
        int count = 0;

        // Check each field and count if it's non-default
        if (obj.getItemId() != null) {
            count++;
        }
        if (obj.getItemName() != null && !obj.getItemName().isEmpty()) {
            count++;
        }
        if (obj.getOneDayAveragePrice() != null && obj.getOneDayAveragePrice().compareTo(BigDecimal.ZERO) != 0) {
            count++;
        }
        if (obj.getOneDayHourVolume() != null && obj.getOneDayHourVolume().compareTo(BigDecimal.ZERO) != 0) {
            count++;
        }
        if (obj.getSevenDayAveragePrice() != null && obj.getSevenDayAveragePrice().compareTo(BigDecimal.ZERO) != 0) {
            count++;
        }
        if (obj.getSevenDayVolume() != null && obj.getSevenDayVolume().compareTo(BigDecimal.ZERO) != 0) {
            count++;
        }
        if (obj.getThirtyAveragePrice() != null && obj.getThirtyAveragePrice().compareTo(BigDecimal.ZERO) != 0) {
            count++;
        }
        if (obj.getThirtyDayVolume() != null && obj.getThirtyDayVolume().compareTo(BigDecimal.ZERO) != 0) {
            count++;
        }

        return count;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getOneDayAveragePrice() {
        return oneDayAveragePrice;
    }

    public BigDecimal getOneDayHourVolume() {
        return oneDayHourVolume;
    }

    public BigDecimal getSevenDayAveragePrice() {
        return sevenDayAveragePrice;
    }

    public BigDecimal getSevenDayVolume() {
        return sevenDayVolume;
    }

    public BigDecimal getThirtyAveragePrice() {
        return thirtyAveragePrice;
    }

    public BigDecimal getThirtyDayVolume() {
        return thirtyDayVolume;
    }

    public BigDecimal getAveragePrice(PriceCalculationPeriod period) {
        return switch (period) {
            case ONE_DAY -> getOneDayAveragePrice();
            case SEVEN_DAY -> getSevenDayAveragePrice();
            case THIRTY_DAY -> getThirtyAveragePrice();
        };
    }
}
