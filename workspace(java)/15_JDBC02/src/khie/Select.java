package khie;

import java.sql.*;

public class Select {

	public static void main(String[] args) {

		Connection con = null;				// DB와 연결하는 객체
		
		PreparedStatement pstmt = null;		// SQL문을 DB에 전송하는 객체
		
		ResultSet rs = null;				// SQL문을 실행한 후의 결과값을 가지고 있는 객체
		
		try {
			//1단계 + 2단계: 오라클 드라이버 로딩 및 오라클 데이터베이스 연결 시도.
			con = DBConnection.getConnection();
//			if(con != null) {
//			System.out.println("데이터베이스 연결 성공");
//		}else {
//			System.out.println("데이터베이스 연결 실패");
//		}

			
			//3단계: 데이터베이스에 전송할 SQL문 작성
			String sql = "select * from emp order by empno desc";
			
			pstmt = con.prepareStatement(sql);
			
			//4단계: 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			//5단계: while 반복문을 이용하여 데이터를 가져와서 출력
			while(rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getString("hiredate").substring(0, 10) + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.println(rs.getInt("deptno") + "\t");
				System.out.println("=========================================");
			}
			
			//6단계: 오라클 데이터베이스와 연결되어있던 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
