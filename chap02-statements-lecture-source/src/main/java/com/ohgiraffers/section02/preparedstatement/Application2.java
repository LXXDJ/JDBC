package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* PreparedStatement는 Statement와 달리 placeholder(?)를 사용한 쿼리를 캐싱하여 다시 재해석하는 과정을 생략함으로
*  한번 캐싱되어 있는 불완전하게 작성된 쿼리 실행의 경우 Statement보다 빠르다. */
public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("사원번호 입력 : ");
        String empId = sc.nextLine();

        String entYn = "N";

        /* PreparedStatement는 Statement 때와 달리, placeholder(?)를 활용한 하나의 문자열 형태로 쿼리 작성 가능 */
        /* 쿼리문을 미완성 형태로 작성해 놓고 쓰기 때문에, 한번 해놓으면 속도가 빨라진다는 장점 보유 */
        // String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?";
        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);  // 1의 의미 : 첫번째 물음표(placeholder)에 empId 값을 넣겠다는 의미
            pstmt.setString(2, entYn);

            rset = pstmt.executeQuery();

            /* 단일행 출력할거기 때문에 if문(사원번호에 해당하는 사원 한명) / 여러행이었다면 while문 이용 */
            if(rset.next()){
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
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
