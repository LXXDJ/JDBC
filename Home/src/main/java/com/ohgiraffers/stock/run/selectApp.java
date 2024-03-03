package com.ohgiraffers.stock.run;

import java.util.Scanner;

public class selectApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주식명 : ");
        String name = sc.nextLine();

        new selectController().selectMenu(name);
    }
}
