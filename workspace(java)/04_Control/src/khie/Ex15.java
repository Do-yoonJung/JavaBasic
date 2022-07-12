package khie;

import java.util.Scanner;

/*
 * switch~case문 - 분기문(조건문)
 * 	식(정수 또는 char)을 사용해서 다중 분기하는 명령문
 * 	jdk 1.7 버전부터는 식에 String 사용 가능함
 * 	
 *		형식)
 *				switch(식 또는 값) {
 *					case 값1 :
 *								값이 1일 때 실행문;
 *								break; // switch~case 블럭 탈출
 *					case 값2 :
 *								값이 2일 때 실행문;
 *								break; // switch~case 블럭 탈출
 *					case 값3 :
 *								값이 3일 때 실행문;
 *								break; // switch~case 블럭 탈출
 *					default :
 *								값1 ~ 값3 이외의 값이 들어온 경우 실행문;
 *								// 생략도 가능함
 *				}
 */

public class Ex15 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1 ~ 3 사이의 숫자 중 하나를 입력하세요: ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1 :
				System.out.println("입력받은 숫자는 1 입니다.");
				break;
			case 2 :
				System.out.println("입력받은 숫자는 2 입니다.");
				break;
			case 3 :
				System.out.println("입력받은 숫자는 3 입니다.");
				break;
			default :
				System.out.println("1 ~ 3 이외의 숫자가 입력되었습니다.");
		}
		
		sc.close();
	}
}