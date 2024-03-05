package com.ohgiraffers.stock_default.controller;

import com.ohgiraffers.stock_default.dto.stockDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.stock_default.common.JDBCTemplate.close;
import static com.ohgiraffers.stock_default.common.JDBCTemplate.getConnection;

public class viewallController {
    public void viewallStock() {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Properties prop = new Properties();

        stockDTO row = null;
        List<stockDTO> empList = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock_default/mapper/stock-query.xml"));
            String query = prop.getProperty("viewallStock");
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            while(rset.next()){
                row = new stockDTO();
                row.setStockName(rset.getString("STK_NAME"));
                row.setStockPrice(rset.getInt("STK_PRICE"));

                empList.add(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        for(stockDTO i : empList){
            System.out.println(i);
        }
    }
}
