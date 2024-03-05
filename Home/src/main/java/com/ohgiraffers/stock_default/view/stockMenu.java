package com.ohgiraffers.stock_default.view;

import com.ohgiraffers.stock_default.dto.stockDTO;
import com.ohgiraffers.stock_default.controller.*;
import com.ohgiraffers.stock_default.dto.memberDTO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class stockMenu {
    private Scanner sc = new Scanner(System.in);

    public stockMenu(){}
    public void mainPage(){
        System.out.println("주식 프로그램 실행");

        insertMember();

        label: while(true){
            System.out.println("=== 메인 메뉴 ===\n0. 프로그램 종료\n1. 전체 주식보기\n2. 내 정보\n3. 현금 추가입금\n4. 주식 구매\n5. 주식 판매");
            System.out.println("6. 주식 검색\n7. 전체 거래내역 보기");
            System.out.print("메뉴 선택 : ");
            String index = sc.nextLine();

            switch (index){
                case "0" : new truncateController().truncateData();
                    System.out.println("프로그램 종료");
                    break;
                case "1" : new viewallController().viewallStock();
                    continue label;
                case "2" : showAccount();
                    continue label;
                case "3" : addMoney();
                    continue label;
                case "4" : buyStock();
                    continue label;
                case "5" : sellStock();
                    continue label;
                case "6" : searchStock();
                    continue label;
                case "7" : new transactionController().showTransaction();
                    continue label;
                default:
                    System.out.println("보기중에서 선택해주세요.");
                    continue label;
            }
            break;
        }
    }

    public void insertMember(){
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();

        int money=0;
        label: while (true){
            money=0;
            System.out.print("현금 입금(최대 20억) : ");

            try{
                long longMoney=0;
                longMoney =sc.nextLong();
                money=(int)longMoney;
                if(money > 2000000000 || longMoney!=money){
                    System.out.println("최대 입금 금액은 20억 입니다. 20억을 입금합니다.");
                    money=2000000000;
                }else if(money <= 0){
                    System.out.println("0 또는 음수는 입력하실 수 없습니다. 다시 입력해주세요.");
                    continue label;
                }
            }catch (InputMismatchException e){
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                continue label;
            }
            sc.nextLine();
            break;
        }

        memberDTO memberDTO = new memberDTO();
        memberDTO.setMemId(id);
        memberDTO.setMemName(name);
        memberDTO.setMemMoney(money);

        int index = new insertController().insertMem(memberDTO);

        if(index>0){
            System.out.println("입장성공");
        }else{
            System.out.println("입장실패");
        }
    }

    public void showAccount(){
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();

        new accountController().accountInfo(id);
    }

    public void addMoney(){
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("추가입금 금액 : ");
        int price = sc.nextInt();
        sc.nextLine();

        int index = new updateController().updateMoney(id, price);

        if(index>0){
            System.out.println("추가입금 성공");
        }else{
            System.out.println("추가입금 실패");
        }
    }

    public void buyStock(){
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("매수 주식명 : ");
        String name = sc.nextLine();
        System.out.print("매수 주식개수 : ");
        int count = sc.nextInt();
        sc.nextLine();

        stockDTO stockDTO = new stockDTO();
        stockDTO.setStockName(name);
        stockDTO.setCount(count);

        int index = new stockController().transactStock(id, stockDTO);

        if(index>0){
            System.out.println("매수성공");
        }else{
            System.out.println("매수실패");
        }
    }

    public void sellStock(){
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("매도 주식명 : ");
        String name = sc.nextLine();
        System.out.print("매도 주식개수 : ");
        int count = sc.nextInt();
        sc.nextLine();

        stockDTO stockDTO = new stockDTO();
        stockDTO.setStockName(name);
        stockDTO.setCount(-count);

        int index = new stockController().transactStock(id, stockDTO);

        if(index>0){
            System.out.println("매도성공");
        }else{
            System.out.println("매도실패");
        }
    }

    private void searchStock() {
        System.out.print("주식명 입력 : ");
        String name = sc.nextLine();

        new searchController().searchStock(name);
    }
}
