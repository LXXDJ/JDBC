package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.common.JDBCTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.menu.common.JDBCTemplate.close;

public class updateController {
    public int updateMoney(int price) {
        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock/mapper/stock-query.xml"));
            String query = prop.getProperty("updateMoney");
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, price);
            pstmt.setString(2, "이다정");

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
