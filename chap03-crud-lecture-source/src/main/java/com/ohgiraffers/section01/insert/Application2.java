package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        /* 1. 메뉴의 이름, 가격, 카테고리코드, 판매여부 입력받기 (Scanner 이용) */
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);

        System.out.print("메뉴명 입력 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴가격 입력 : ");
        int menuPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("카테고리코드 입력 : ");
        int menuCategory = sc.nextInt();
        sc.nextLine();
        System.out.print("판매여부(Y/N) 입력 : ");
        String menuOrder = sc.nextLine().toUpperCase();

        /* MenuDTO 객체를 생성하여 입력받은 값으로 세팅 */
        MenuDTO dto = new MenuDTO();
        dto.setMenuName(menuName);
        dto.setMenuPrice(menuPrice);
        dto.setMenuCategory(menuCategory);
        dto.setMenuOrder(menuOrder);

        /* InsertController의 insertMenu() 메소드 호출 */
        int result = new InsertController().insertMenu(dto);

        /* insert 결과에 따라 실행결과가 성공이면 '메뉴등록 성공', 실패면 '메뉴등록 실패' */
        if(result > 0) {
            System.out.println("메뉴등록 성공");
        }else{
            System.out.println("메뉴등록 실패");
        }
    }
}
