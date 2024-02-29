package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* Statement와 달리, placeholder(?)를 통해 SQL injection 공격을 막을 수 있게 작성되어 있어
*  보안적 측면에서 우수 (그래서 Statement는 거의 안 쓰고, prepareStatement 사용) */
public class Application3 {
    private static String empId = "210";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";
    
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 아래 SQL과 같이 prepareStatement는 placeholder로 입력되는 값에 홑따옴표(')가 있다면, 홑따옴표를 하나 더 붙여주고
        *  setString 값이 들어갈 때도 양 옆에 홑따옴표를 붙여준다. */
        // SELECT * FROM EMPLOYEE WHERE EMP_ID = '210' AND EMP_NAME = ''' OR 1=1 AND EMP_ID = ''200'   // 이렇게 홑따옴표가 추가된다.
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";
        System.out.println("query = " + query);  // SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);

            rset = pstmt.executeQuery();

            if(rset.next()){
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원 정보 없음");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
