package com.ohgiraffers.model.dto;

public class MenuDTO implements java.io.Serializable {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int menuCategory;
    private String menuOrder;

    public MenuDTO(){};

    public MenuDTO(int menuCode, String menuName, int menuPrice, int menuCategory, String menuOrder) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategory = menuCategory;
        this.menuOrder = menuOrder;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(int menuCategory) {
        this.menuCategory = menuCategory;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuCategory=" + menuCategory +
                ", menuOrder='" + menuOrder + '\'' +
                '}';
    }
}
