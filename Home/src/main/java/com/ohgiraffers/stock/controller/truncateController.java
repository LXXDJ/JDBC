package com.ohgiraffers.stock.controller;

import com.ohgiraffers.stock.common.JDBCTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.stock.common.JDBCTemplate.close;

public class truncateController {
    public void truncateData(){
        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock/mapper/stock-query.xml"));
            String query = prop.getProperty("truncateMember");
            pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();

            String query1 = prop.getProperty("truncateTransaction");
            pstmt1 = con.prepareStatement(query1);
            pstmt1.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt1);
            close(pstmt);
            close(con);
        }
    }
}
