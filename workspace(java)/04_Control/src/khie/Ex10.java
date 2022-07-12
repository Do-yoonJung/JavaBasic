package khie;

import java.util.Scanner;

//[문제] 키보드로 입력받은 정수가 홀수인지 짝수인지 판별해보세요

public class Ex10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	//import단축키 ctrl + shift + o 아니면 ctrl + space
		System.out.print("정수를 입력해주세요: ");
		int num = sc.nextInt();
		
		if((num % 2) == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
		sc.close();
	}
}