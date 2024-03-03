package com.ohgiraffers.menu.run;

import com.ohgiraffers.menu.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.menu.common.JDBCTemplate.close;
import static com.ohgiraffers.menu.common.JDBCTemplate.getConnection;

public class selectController {
    public ResultSet selectMenu(int index){
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Properties prop = new Properties();
        MenuDTO dto = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
            String query = prop.getProperty("selectMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, index);
            rset = pstmt.executeQuery();

            if(rset.next()){
                dto = new MenuDTO();
                dto.setMenuName(rset.getString("MENU_NAME"));
                dto.setMenuPrice(rset.getInt("MENU_PRICE"));
                dto.setMenuCategory(rset.getInt("CATEGORY_CODE"));
                dto.setMenuOrderable(rset.getString("ORDERABLE_STATUS"));
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

        return rset;
    }
}
