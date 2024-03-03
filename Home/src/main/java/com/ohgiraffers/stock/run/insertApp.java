package com.ohgiraffers.stock.run;

import java.util.Scanner;

public class insertApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("현금 입금 : ");
        int money = sc.nextInt();
        sc.nextLine();

        int index = new insertController().insertMem(name, money);

        if(index>0){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }
}
