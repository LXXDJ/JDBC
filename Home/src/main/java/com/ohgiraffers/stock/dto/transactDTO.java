package com.ohgiraffers.stock.dto;

public class transactDTO {
    private int code;
    private String memName;
    private String stkName;
    private int stkPrice;
    private int stkCount;

    public transactDTO(){}

    public transactDTO(int code, String memName, String stkName, int stkPrice, int stkCount) {
        this.code = code;
        this.memName = memName;
        this.stkName = stkName;
        this.stkPrice = stkPrice;
        this.stkCount = stkCount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getStkName() {
        return stkName;
    }

    public void setStkName(String stkName) {
        this.stkName = stkName;
    }

    public int getStkPrice() {
        return stkPrice;
    }

    public void setStkPrice(int stkPrice) {
        this.stkPrice = stkPrice;
    }

    public int getStkCount() {
        return stkCount;
    }

    public void setStkCount(int stkCount) {
        this.stkCount = stkCount;
    }

    @Override
    public String toString() {
        return "transactDTO{" +
                "code=" + code +
                ", memName='" + memName + '\'' +
                ", stkName='" + stkName + '\'' +
                ", stkPrice=" + stkPrice +
                ", stkCount=" + stkCount +
                '}';
    }
}
