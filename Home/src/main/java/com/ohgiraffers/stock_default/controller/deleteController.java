package com.ohgiraffers.stock_default.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.stock_default.common.JDBCTemplate.close;
import static com.ohgiraffers.stock_default.common.JDBCTemplate.getConnection;

public class deleteController {
    public int deleteStock(String name) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock_default/mapper/stock-query.xml"));
            String query = prop.getProperty("deleteStock");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            result = pstmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        return result;
    }
}
