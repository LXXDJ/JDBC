package com.ohgiraffers.menu.dto;

import java.io.Serializable;

public class MenuDTO implements Serializable {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int menuCategory;
    private String menuOrderable;

    public MenuDTO(){}

    public MenuDTO(int menuCode, String menuName, int menuPrice, int menuCategory, String menuOrderable) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategory = menuCategory;
        this.menuOrderable = menuOrderable;
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

    public String getMenuOrderable() {
        return menuOrderable;
    }

    public void setMenuOrderable(String menuOrderable) {
        this.menuOrderable = menuOrderable;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuCategory=" + menuCategory +
                ", menuOrderable='" + menuOrderable + '\'' +
                '}';
    }
}
