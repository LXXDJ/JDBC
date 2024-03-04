package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.dto.memberDTO;
import com.ohgiraffers.stock.dto.stockDTO;

import java.util.Scanner;

public class buyApp {
    public static void main(String[] args) {
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
}
