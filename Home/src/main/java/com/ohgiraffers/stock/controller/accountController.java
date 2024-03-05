package com.ohgiraffers.stock.controller;

import com.ohgiraffers.stock.common.JDBCTemplate;
import com.ohgiraffers.stock.dto.memberDTO;
import com.ohgiraffers.stock.dto.stockDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class accountController {
    public void accountInfo(String id) {
        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rset = null;
        ResultSet rset1 = null;
        Properties prop = new Properties();

        memberDTO mem = null;
        List<memberDTO> memList = null;

        stockDTO row = null;
        List<stockDTO> empList = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock/mapper/stock-query.xml"));

            String query1 = prop.getProperty("myInfo");
            pstmt1 = con.prepareStatement(query1);
            pstmt1.setString(1, id);
            rset1 = pstmt1.executeQuery();

            memList = new ArrayList<>();

            while(rset1.next()){
                mem = new memberDTO();
                mem.setMemId(rset1.getString("MEM_ID"));
                mem.setMemName(rset1.getString("MEM_NAME"));
                mem.setMemMoney(rset1.getInt("MEM_MONEY"));

                memList.add(mem);
            }

            String query = prop.getProperty("calcStock");
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            while(rset.next()){
                row = new stockDTO();
                row.setStockName(rset.getString("STK_NAME"));
                row.setStockPrice(rset.getInt("AVG(STK_PRICE)"));
                row.setCount(rset.getInt("SUM(STK_COUNT)"));

                empList.add(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset1);
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt1);
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(con);
        }

        for(memberDTO i : memList){
            System.out.println(i);
        }

        for(stockDTO i : empList){
            System.out.println(i);
        }
    }
}
