package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.dto.stockDTO;

import java.util.Scanner;

public class sellApp {
    public static void main(String[] args) {
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
