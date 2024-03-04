package com.ohgiraffers.stock.run;

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

public class sellController {
    public int sellStock(stockDTO stockDTO) {
        Connection con = getConnection();
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rset1 = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock/mapper/stock-query.xml"));
            String query1 = prop.getProperty("selectStock");
            pstmt1 = con.prepareStatement(query1);
            pstmt1.setString(1, stockDTO.getStockName());
            rset1 = pstmt1.executeQuery();

            if(rset1.next()){
                stockDTO.setStockPrice(rset1.getInt("STK_PRICE"));
            }

            String query2 = prop.getProperty("insertTransaction");
            pstmt2 = con.prepareStatement(query2);
            pstmt2.setString(1, "홍길동");
            pstmt2.setString(2, stockDTO.getStockName());
            pstmt2.setInt(3, stockDTO.getStockPrice());
            pstmt2.setInt(4, -(stockDTO.getCount()));
            pstmt2.setString(5, "Y");
            result = pstmt2.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset1);
            close(pstmt2);
            close(pstmt1);
            close(con);
        }

        return result;
    }
}
