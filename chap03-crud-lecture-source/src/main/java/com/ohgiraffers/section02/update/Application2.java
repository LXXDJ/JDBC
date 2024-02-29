package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* 1. 변경할 메뉴코드, 이름, 가격 입력받기 */
        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴코드 입력 : ");
        int menuCode = sc.nextInt();
        sc.nextLine();
        System.out.print("변경할 메뉴명 입력 : ");
        String menuName = sc.nextLine();
        System.out.print("변경할 메뉴가격 입력 : ");
        int menuPrice = sc.nextInt();
        sc.nextLine();

        /* 2. MenuDTO 객체 생성, 입력받은 값으로 세팅 */
        MenuDTO dto = new MenuDTO();
        dto.setMenuCode(menuCode);
        dto.setMenuName(menuName);
        dto.setMenuPrice(menuPrice);

        /* 3. UpdateController의 updateMenu() 메소드 호출 */
        int result = new UpdateController().updateMenu(dto);

        /* 4. update 결과에 따라 성공, 실패 메세지 출력 */
        if(result > 0) {
            System.out.println("메뉴수정 성공");
        } else {
            System.out.println("메뉴수정 실패");
        }
    }
}
