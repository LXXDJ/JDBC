package com.ohgiraffers.stock.run;

import com.ohgiraffers.stock.dto.memberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.stock.common.JDBCTemplate.close;
import static com.ohgiraffers.stock.common.JDBCTemplate.getConnection;

public class insertController {
    public int insertMem(String str, int num){
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/stock/mapper/stock-query.xml"));
            String query = prop.getProperty("insertMember");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, str);
            pstmt.setInt(2, num);
            result = pstmt.executeUpdate();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        return result;
    }
}
