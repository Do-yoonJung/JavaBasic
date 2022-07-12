package khie;

import javax.swing.JOptionPane;

//[문제] 키보드로부터 입력받은 점수가 60점 이상이면 "합격" 이라는 메세지를 출력

public class Ex05 {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		//1. 키보드로부터 점수를 입력 받기
		int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
		
		//2. 입력 받은 점수가 60점 이상인지 조건식을 이용하여 판별
		if(score >= 60) {
			System.out.println("합격");
		}
		
		System.out.println("프로그램 종료");
	}
}