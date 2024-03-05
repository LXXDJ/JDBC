package com.ohgiraffers.stock_default.dto;

public class stockDTO {
    private String stockName;
    private int stockPrice;
    private int count;

    public stockDTO(){};
    public stockDTO(String stockName, int stockPrice, int count) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.count = count;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "stockDTO{" +
                "stockName='" + stockName + '\'' +
                ", stockPrice=" + stockPrice +
                ", count=" + count +
                '}';
    }
}
