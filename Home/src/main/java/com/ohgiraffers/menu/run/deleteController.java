package com.ohgiraffers.menu.run;

import com.ohgiraffers.menu.common.JDBCTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.menu.common.JDBCTemplate.close;

public class deleteController {
    public int deleteMenu(int index){
        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/menu/mapper/menu-query.xml"));
            String query = prop.getProperty("deleteMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, index);
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
