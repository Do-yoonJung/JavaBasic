package khie;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int su = sc.nextInt();
			System.out.println("입력받은 수:" + su);
		}catch(Exception e) {
			System.out.println("정수만 입력하세요.");
			System.out.println("예외 정보: " + e);
		}finally {
			//입출력과 관련된 데이터를 처리하는 코드
			sc.close();
		}
		
		System.out.println("프로그램 종료");
		
	}

}
