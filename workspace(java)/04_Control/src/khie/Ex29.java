package khie;

import java.util.Scanner;

/*
 * 신장별 표준 체중 대응표를 만들어보자.
 * 표시할 신장이 범위(시작값/종료값/증가값)는 정수로 할 예정이며
 * 키보드로 입력 받을 예정
 * 	표중 체중 구하는 공식: (신장 - 100) * 0.9
 */

public class Ex29 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 cm부터 표시할까요? ");
		
		int start = sc.nextInt();
		
		System.out.print("몇 cm까지 표시할까요? ");
		
		int end = sc.nextInt();
		
		System.out.print("몇 cm 단위로 표시할까요? ");
		
		int step = sc.nextInt();
		
		System.out.println();
		
		for(int i = start; i <= end; i = i + step) {
			System.out.printf("%dcm\t%.2fkg\n", i, ((i-100)*0.9));
		}
		
		sc.close();
	}
}