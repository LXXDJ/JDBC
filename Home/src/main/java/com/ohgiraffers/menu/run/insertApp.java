package com.ohgiraffers.menu.run;

import com.ohgiraffers.menu.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static com.ohgiraffers.menu.common.JDBCTemplate.getConnection;

public class insertApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명 : ");
        String name = sc.nextLine();
        System.out.print("메뉴가격 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("카테고리 : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.print("주문여부 : ");
        String orderable = sc.nextLine();

        MenuDTO dto = new MenuDTO();
        dto.setMenuName(name);
        dto.setMenuPrice(price);
        dto.setMenuCategory(category);
        dto.setMenuOrderable(orderable);

        int idx = new insertController().insertMenu(dto);

        if(idx > 0) {
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }
}
