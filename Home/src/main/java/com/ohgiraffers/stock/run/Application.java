package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.dto.memberDTO;
import com.ohgiraffers.stock.dto.stockDTO;

import javax.swing.plaf.PanelUI;
import java.util.Scanner;

public class Application {
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

        label: while(true){
            System.out.println("=== 메인 메뉴 ===\n0. 프로그램 종료\n1. 전체 주식보기\n2. 내 정보\n3. 현금 추가입금\n4. 주식 구매\n5. 주식 판매");
            System.out.print("메뉴 선택 : ");
            String idx = sc.nextLine();

            switch (idx){
                case "0" :
                    System.out.println("프로그램 종료");
                    break;
                case "1" : new viewallController().viewallStock();
                    continue label;
                case "2" : new accountController().accountInfo();
                    continue label;
                case "3" : addMoney();
                    continue label;
                case "4" : buy();
                    continue label;
                case "5" : sell();
                    continue label;
                default:
                    System.out.println("보기중에서 선택해주세요.");
                    continue label;
            }
            break;
        }
    }

    public static void addMoney(){
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

    public static void buy(){
        Scanner sc = new Scanner(System.in);
        System.out.print("매수 주식명 : ");
        String name = sc.nextLine();
        System.out.print("매수 주식개수 : ");
        int count = sc.nextInt();
        sc.nextLine();

        stockDTO stockDTO = new stockDTO();
        stockDTO.setStockName(name);
        stockDTO.setCount(count);

        int index = new buyController().buyStock(stockDTO);

        if(index>0){
            System.out.println("매수성공");
        }else{
            System.out.println("매수실패");
        }
    }
    public static void sell(){
        Scanner sc = new Scanner(System.in);
        System.out.print("매도 주식명 : ");
        String name = sc.nextLine();
        System.out.print("매도 주식개수 : ");
        int count = sc.nextInt();
        sc.nextLine();

        stockDTO stockDTO = new stockDTO();
        stockDTO.setStockName(name);
        stockDTO.setCount(count);

        int index = new sellController().sellStock(stockDTO);

        if(index>0){
            System.out.println("매도성공");
        }else{
            System.out.println("매도실패");
        }
    }
}
