package com.ohgiraffers.stock.dto;

public class memberDTO {
    private String memId;
    private String memName;
    private int memMoney;

    public memberDTO(){}

    public memberDTO(String memId, String memName, int memMoney) {
        this.memId = memId;
        this.memName = memName;
        this.memMoney = memMoney;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
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
                "memId='" + memId + '\'' +
                ", memName='" + memName + '\'' +
                ", memMoney=" + memMoney +
                '}';
    }
}
