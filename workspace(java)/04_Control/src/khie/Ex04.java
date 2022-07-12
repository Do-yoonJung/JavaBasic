package khie;

import javax.swing.JOptionPane;

// [문제] 키보드로부터 입력받은 정수 값이 음수이면 "입력받은 정수는 음수입니다."라는 메세지를 콘솔 화면에 출력

public class Ex04 {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		//1. 키보드로부터 정수를 입력 받기
		int num = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요."));
		
		//2. 입력받은 정수가 음수인지 조건식을 이용하여 판별
		if(num < 0) { //음수를 판별하는 조건식
			System.out.println("입력 받은 " + num + " 는 음수입니다.");
		}
		
		System.out.println("프로그램 종료");
	}
}