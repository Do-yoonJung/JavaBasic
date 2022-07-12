package method;

import java.util.Scanner;

public class Ex09 {
	
	//2과목의 초점을 구하는 메서드
	public static int sum2(int k, int e) {
		return k + e;
	}
	
	//3과목의 총점의 구하는 메서드
	public static int sum3(int k, int e, int m) {
		return k + e + m;
	}
	
	//4과목의 총점을 구하는 메서드
	public static int sum4(int k, int e, int m, int j) {
		return k + e + m + j;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 입력: ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수 입력: ");
		int eng = sc.nextInt();
		
		System.out.print("수학점수 입력: ");
		int math = sc.nextInt();
		
		System.out.print("자바점수 입력: ");
		int java = sc.nextInt();
		
		System.out.println();
		
		System.out.println("2과목 총점: " + sum2(kor, eng));
		
		System.out.println("3과목 총점: " + sum3(kor, eng, math));
		
		System.out.println("4과목 총점: " + sum4(kor, eng, math, java));
		
		sc.close();
		
	}
}
