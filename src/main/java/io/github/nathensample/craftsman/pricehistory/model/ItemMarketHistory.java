package io.github.nathensample.craftsman.pricehistory.model;

import java.math.BigDecimal;

public class ItemMarketHistory {
    private Integer itemId;
    private String itemName;
    private BigDecimal oneDayAveragePrice;
    private BigDecimal oneDayHourVolume;
    private  BigDecimal sevenDayAveragePrice;
    private BigDecimal sevenDayVolume;
    private  BigDecimal thirtyAveragePrice;
    private BigDecimal thirtyDayVolume;

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
}
