package com.ohgiraffers.menu.run;

import java.util.Scanner;

public class selectApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴코드 : ");
        int code = sc.nextInt();
        sc.nextLine();

        System.out.println(new selectController().selectMenu(code));
    }
}
