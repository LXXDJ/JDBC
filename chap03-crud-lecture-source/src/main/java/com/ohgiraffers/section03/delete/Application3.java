package com.ohgiraffers.section03.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        /* 1. 삭제할 메뉴 코드 입력 받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴코드 입력 : ");
        int menuCode = sc.nextInt();
        sc.nextLine();

        /* 2. DeleteController의 deleteMenu() 메소드 호출 */
        int result = new DeleteController().deleteMenu(menuCode);

        /* 3. delete 결과에 따라 성공, 실패 메세지 출력 */
        if(result > 0){
            System.out.println("메뉴삭제 성공");
        }else{
            System.out.println("메뉴삭제 실패");
        }

        /* entry key = deleteMenu */
    }
}
