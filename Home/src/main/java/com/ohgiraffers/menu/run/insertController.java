package com.ohgiraffers.menu.run;

import com.ohgiraffers.menu.common.JDBCTemplate;
import com.ohgiraffers.menu.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.menu.common.JDBCTemplate.close;

public class insertController {
    public int insertMenu(MenuDTO dto){
        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/menu/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, dto.getMenuName());
            pstmt.setInt(2, dto.getMenuPrice());
            pstmt.setInt(3, dto.getMenuCategory());
            pstmt.setString(4, dto.getMenuOrderable());

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
