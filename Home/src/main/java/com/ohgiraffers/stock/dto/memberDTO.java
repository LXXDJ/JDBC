package com.ohgiraffers.stock.dto;

public class memberDTO {
    private String memName;
    private int memMoney;

    public memberDTO(){}

    public memberDTO(String memName, int memMoney) {
        this.memName = memName;
        this.memMoney = memMoney;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getMemMoney() {
        return memMoney;
    }

    public void setMemMoney(int memMoney) {
        this.memMoney = memMoney;
    }

    @Override
    public String toString() {
        return "memberDTO{" +
                "memName='" + memName + '\'' +
                ", memMoney=" + memMoney +
                '}';
    }
}
