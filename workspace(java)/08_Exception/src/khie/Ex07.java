package khie;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 다중 catch문
 * - catch문을 여러 개 사용하여 예외를 처리하는 방식.
 * - catch문은 순차적으로 위에서 아래로 실행이 됨.
 * - 주의) 예외를 처리하는 가장 최상위의 Exception 클래스는 맨 마지막 줄에 나와야 함.
 * 		  (만약 맨 첫 줄에 나오는 경우 error 발생)
 */

public class Ex07 {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		String str = "korea";
		
		int[] arr = {10,20,30,40,50};
		
		try {
			num = sc.nextInt();	//예외가 발생할 가능성이 있는 코드
			
			System.out.println("str 문자열의 길이: " + str.length());
			
			arr[5] = 60;
			
		}catch(InputMismatchException e) {
			System.out.println("입력 오류 예외");
			System.out.println("예외 정보 " + e);
		}catch(NullPointerException e) {
			System.out.println("null 값을 갖는 오류 발생");
			System.out.println("예외 정보: " + e);
		}catch(Exception e) {
			System.out.println("모르는 예외 발생");
			System.out.println("예외정보 " + e);
		}
		
		System.out.println("프로그램 종료");
		sc.close();
	}

}
