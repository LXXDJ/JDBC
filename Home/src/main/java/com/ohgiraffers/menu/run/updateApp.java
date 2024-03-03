package com.ohgiraffers.menu.run;

import com.ohgiraffers.menu.dto.MenuDTO;

import java.util.Scanner;

public class updateApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴코드 : ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("메뉴명 : ");
        String name = sc.nextLine();
        System.out.print("메뉴가격 : ");
        int price = sc.nextInt();
        sc.nextLine();

        MenuDTO dto = new MenuDTO();
        dto.setMenuCode(code);
        dto.setMenuName(name);
        dto.setMenuPrice(price);

        int idx = new updateController().updateMenu(dto);

        if(idx>0){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }
}
