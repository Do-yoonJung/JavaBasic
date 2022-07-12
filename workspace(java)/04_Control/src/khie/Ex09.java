package khie;

import java.util.Scanner;

/*
 * [문제] 키보드로 점수를 입력받아서 입력받은 점수가 60점 이상이면 "합격"이라는 문자열을 출력,
 * 그렇지 않으면 "불합격"이라는 문자열을 출력하시오.
 */


public class Ex09 {

	public static void main(String[] args) {
		
		//1. 키보드로 점수 입력 받기 3번째 방법
		//int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
		
		//키보드로 입력받기 위한 준비 작업
		//System.in : 표준입력장치(키보드)
		Scanner sc = new Scanner(System.in);	//Scanner는 형변환이 필요 없음
		
		System.out.print("점수를 입력하세요. : ");
		int score = sc.nextInt();
		
		
		if(score >= 60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		//Scanner 종료
		sc.close();
	}
}