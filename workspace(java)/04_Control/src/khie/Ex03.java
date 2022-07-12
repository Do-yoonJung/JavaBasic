package khie;

import javax.swing.JOptionPane;

//[문제] 키보드로 입력 받은 정수가 5로 나누어 떨어지면 "이 정수는 5의 배수입니다." 라고 메세지를 화면에 출력하시오.

public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		//1. 키보드로부터 정수 하나를 입력을 받자
		int num = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요"));
		//JOptionPane jop 텍스트 상자여서 형변환을 해야 함
		
		//2. 5로 나눈 나머지가 0인지 확인을 하자
		if((num % 5) == 0) {
			System.out.println("입력 받은 " + num + " 는 5의 배수입니다.");
		}
		
		System.out.println("프로그램 종료");
	}
}