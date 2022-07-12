package exam04;

import java.util.Scanner;

public class Exam01 {
	//학생등록 메서드
	public static void input(String[] n, int[] num, String[] m, String[] p, Scanner sc) {
		for(int i=0; i<n.length; i++) {
			System.out.println((i+1) + "번째 학생 정보 입력");
			System.out.print("이름 입력: ");
			n[i] = sc.next();
			System.out.print("학번 입력: ");
			num[i] = sc.nextInt();
			System.out.print("학과 입력: ");
			m[i] = sc.next();
			System.out.print("연락처 입력: ");
			p[i] = sc.next();
		}
		System.out.println();
		System.out.println("학생 정보 저장 완료.....");
	}
	
	//전체출력 메서드
	public static void print(String[] n, int[] num, String[] m, String[] p) {
		for(int i=0; i<n.length; i++) {
			System.out.println((i+1) + "번째 학생 정보 출력");
			System.out.println("이름: " + n[i]);
			System.out.println("학번: " + num[i]);
			System.out.println("학과: " + m[i]);
			System.out.println("연락처: " + p[i]);
			System.out.println("========================================");
		}
	}

	//학생조회 메서드
	public static void search(String[] n, int[] num, String[] m, String[] p, Scanner sc) {
		System.out.println("조회할 학생의 학번을 입력하세요: ");
		int number = sc.nextInt();
		 
		for(int i=0; i<n.length; i++) {
			if(number == num[i]) {
				System.out.print("이름: " + n[i]);
				System.out.print("학번: " + num[i]);
				System.out.print("학과: " + m[i]);
				System.out.print("연락처: " + p[i]);
				System.out.println("========================================");
			}
		}
	}
	
	//학생 정보 수정 메서드
	public static void update(int[] num, String[] m, String[] p, Scanner sc) {
		System.out.println("수정할 학생의 학번을 입력하세요: ");
		int number = sc.nextInt();
		for(int i=0; i<num.length; i++) {
			if(number == num[i]) {
				System.out.print("수정할 학과를 입력하세요: ");
				m[i] = sc.next();
				System.out.print("수정할 연락처를 입력하세요: ");
				p[i] = sc.next();
				System.out.println("========================================");
			}
		}
	}
	
	//프로그램 종료 메서드
	public static String end(Scanner sc) {
		System.out.print("프로그램을 종료하시겠습니까?(y/n): ");
		String end = sc.next();
		return end;
	}
	
	public static void main(String[] args) {
		
		//학생수 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요: ");
		
		//배열 만들기
		String[] names = new String[sc.nextInt()];
		int[] numbers = new int[names.length];
		String[] majors = new String[numbers.length];
		String[] phones = new String[majors.length];
		
		//메뉴 구성
		//무한 반복문
		while(true) {
			System.out.println("***** 학생 관리 프로그램 *****");
			System.out.println("1.학생 등록");
			System.out.println("2.전체 출력");
			System.out.println("3.학생 조회");
			System.out.println("4.정보 수정");
			System.out.println("5.프로그램 종료");
			System.out.println();
			System.out.print("학생 관리 메뉴 중 하나를 선택하세요: ");
			int menu = sc.nextInt();
			
			String end = "";
			switch(menu) {
			case 1 :
				//학생등록 메서드 호출
				input(names, numbers, majors, phones, sc);
				break;
			case 2 :
				//전체 출력 메서드 호출
				print(names, numbers, majors, phones);
				break;
			case 3 :
				//학생 정보 학번으로 조회
				search(names, numbers, majors, phones, sc);
				break;
			case 4 :
				//학생 정보 수정 메서드 호출
				update(numbers, majors, phones, sc);
				break;
			case 5 :
				//프로그램 종료 메서드 호출
				end = end(sc);
				break;
			}
			if(end.equalsIgnoreCase("Y")) {
				break;
			}
		}
	}
}
