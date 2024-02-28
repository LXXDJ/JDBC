package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        /* 이 순서대로 해줘야한다.
        *  1. Connection 생성, 2. Statement 선언, 3. ResultSet 선언 */
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            /* 4. Connection의 createStatement()를 이용한 Statement 인스턴스 생성 */
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("사원번호 입력 : ");
            String empId = sc.nextLine();

            /* empId가 varchar이기 때문에, 홑따옴표를 붙여줘야 제대로 전달된다.*/
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

            System.out.println(query);

            /* 5. executeQuery()로 쿼리문 실행, 결과를 ResultSet으로 반환 받음 */
            rset = stmt.executeQuery(query);

            /* 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해 꺼내어 출력 */
            if(rset.next()){
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }else{
                System.out.println("해당 사원의 조회 결과 없음");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 7. 사용한 자원 반납 (작성 순서의 역순) */
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
