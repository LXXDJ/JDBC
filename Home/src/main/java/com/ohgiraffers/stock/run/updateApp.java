package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.run.updateController;

import java.util.Scanner;

public class updateApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("추가입금 금액 : ");
        int price = sc.nextInt();
        sc.nextLine();

        int idx = new updateController().updateMoney(price);

        if(idx>0){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }
}
