package khie;

import java.sql.*;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {

		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 사번: ");
		
		int empno = sc.nextInt();
		
		try {
			//1,2
			con = DBConnection.getConnection();
			
			//3
			String sql = "delete from emp where empno = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			//4
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 실패");
			}
			
			//5
			pstmt.close(); con.close(); sc.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
