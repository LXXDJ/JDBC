package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.dto.memberDTO;

import java.util.Scanner;

public class insertApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("현금 입금 : ");
        int money = sc.nextInt();
        sc.nextLine();

        memberDTO memberDTO = new memberDTO();
        memberDTO.setMemName(name);
        memberDTO.setMemMoney(money);

        int index = new insertController().insertMem(memberDTO);

        if(index>0){
            System.out.println("입장성공");
        }else{
            System.out.println("입장실패");
        }
    }
}
