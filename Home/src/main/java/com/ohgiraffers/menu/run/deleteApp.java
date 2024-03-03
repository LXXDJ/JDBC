package com.ohgiraffers.menu.run;

import java.util.Scanner;

public class deleteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴코드 : ");
        int code = sc.nextInt();
        sc.nextLine();

        int idx = new deleteController().deleteMenu(code);

        if(idx>0){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }
}
