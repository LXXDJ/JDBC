package com.ohgiraffers.stock.controller;

import com.ohgiraffers.stock.dto.memberDTO;
import com.ohgiraffers.stock.dto.stockDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.stock.common.JDBCTemplate.close;
import static com.ohgiraffers.stock.common.JDBCTemplate.getConnection;

public class stockController {
    public int transactStock(String id, stockDTO stockDTO) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rset = null;
        ResultSet rset1 = null;
        int result = 0;
        Properties prop = new Properties();
        memberDTO memberDTO = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock/mapper/stock-query.xml"));
            String query = prop.getProperty("myInfo");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();

            if(rset.next()){
                memberDTO = new memberDTO();
                memberDTO.setMemName(rset.getString("MEM_NAME"));
            }

            String query1 = prop.getProperty("selectStock");
            pstmt1 = con.prepareStatement(query1);
            pstmt1.setString(1, stockDTO.getStockName());
            rset1 = pstmt1.executeQuery();

            if(rset1.next()){
                stockDTO.setStockPrice(rset1.getInt("STK_PRICE"));
            }

            String query2 = prop.getProperty("insertTransaction");
            pstmt2 = con.prepareStatement(query2);
            pstmt2.setString(1, memberDTO.getMemName());
            pstmt2.setString(2, stockDTO.getStockName());
            pstmt2.setInt(3, stockDTO.getStockPrice());
            pstmt2.setInt(4, stockDTO.getCount());
            result = pstmt2.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset1);
            close(rset);
            close(pstmt2);
            close(pstmt1);
            close(pstmt);
            close(con);
        }

        return result;
    }
}
