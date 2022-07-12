package khie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {

	public static void main(String[] args) {

		Connection con = null;				// DB와 연결하는 객체
		
		PreparedStatement pstmt = null;		// SQL문을 DB에 전송하는 객체
		
		ResultSet rs = null;				// SQL문을 실행한 후의 결과값을 가지고 있는 객체
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		//(C:\WINDOWS.X64_193000_db_home\jdbc\lib)
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		String user = "web";
		
		String password = "1234";
		
		try {
			// 1단계 : 오라클 드라이버를 로딩.
			// ==> 동적으로 로딩 : 프로그램 실행시에 오라클 드라이버를 로딩한다는 의미.
			Class.forName(driver);
			
			System.out.println("드라이버 로딩 성공!!!!");
			
			//2단계 : 오라클 데이터베이스와 연결 시도.
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("오라클 데이터베이스와 연결 성공");
			}
			
			//3단계 : 데이터베이스에 SQL문을 전송하기 위한 쿼리문 작성.
			String sql = "select * from memo order by bunho desc";
			
			pstmt = con.prepareStatement(sql);
			
			//4단계 : 데이터베이스에 SQL문을 전송.
			rs = pstmt.executeQuery();	// 실제로 DB에서 SQL문은 실행하는 메서드.ㅇ
			
			//5단계 : 데이터를 가져와서 출력
			while(rs.next()) {
				int bunho = rs.getInt("bunho");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String cont = rs.getString("cont");
				String regdate = rs.getString("regdate").substring(0, 10);
				
				System.out.println(bunho + "\t" + title + "\t" + writer 
						+ "\t" + cont + "\t" + regdate);
			}
			
			// 6단계 : 연결되어 있던 객체들은 종료해주는 것이 좋다.
			rs.close(); pstmt.close(); con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
