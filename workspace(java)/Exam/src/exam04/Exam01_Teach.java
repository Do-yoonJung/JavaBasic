package exam04;

import java.util.Scanner;

public class Exam01_Teach {
	
	//학생 정보 저장 메서드
	public static void input(String[] n, int[] h, String[] m, String[] p, Scanner sc) {
		
		for(int i=0; i<n.length; i++) {
			System.out.println((i+1) + "번째 학생 정보 입력");
			System.out.print("학생 이름 입력: ");
			n[i] = sc.next();
			System.out.print("학생 학번 입력: ");
			h[i] = sc.nextInt();
			System.out.print("학생 학과 입력: ");
			m[i] = sc.next();
			System.out.print("학생 연락처 입력: ");
			p[i] = sc.next();
		}
		System.out.println();
		System.out.println("학생 정보 저장 완료.....");
	}
	
	//학생 정보를 출력하는 메서드
	public static void output(String[] n, int[] h, String[] m, String[] p) {
		
		for(int i=0; i<h.length; i++) {
			System.out.println("*** " + (i+1) + " 번째 학생 정보 출력 ***");
			System.out.println("학생 이름: " + n[i]);
			System.out.println("학생 학번: " + h[i]);
			System.out.println("학생 학과: " + m[i]);
			System.out.println("학생 연락처: " + p[i]);
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		}
	}
	
	//학생 조회 메서드
	public static void search(String[] n, int[] h, String[] m, String[] p, Scanner sc) {
		
		System.out.print("조회할 학생의 학번을 입력하세요: ");
		int hakbun = sc.nextInt();
		
		for(int i=0; i<p.length; i++) {
			if(hakbun == h[i]) {
				System.out.println("학생 이름: " + n[i]);
				System.out.println("학생 학번: " + h[i]);
				System.out.println("학생 학과: " + m[i]);
				System.out.println("학생 연락처: " + p[i]);
			}
		}
	}
	
	//학생의 정보를 수정하는 메서드
	public static void update(int[] h, String[] m, String[] p, Scanner sc) {
		
		System.out.print("수정할 학생의 학번을 입력하세요: ");
		int hakbun = sc.nextInt();
		
		for(int i=0; i<m.length; i++) {
			if(hakbun == h[i]) {
				System.out.print("수정할 학생 학과 입력: ");
				m[i] = sc.next();
				
				System.out.print("수정할 학생의 연락처 입력: ");
				p[i] = sc.next();
			}
		}
	}
	
	//프로그램을 종료하는 메서드
	public static String end(Scanner sc) {

		System.out.print("프로그램을 종료하시겠습니까?(y/n) : ");
		
		String end = sc.next();

		return end;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//1.키보드로 학생수 입력 받기
		System.out.println("학생 수를 입력하세요: ");
		
		//2.학생 정보 배열에 입력받은 학생 수 만큼의 배열을 생성
		String[] names = new String[sc.nextInt()];
		int[] hakbuns = new int[names.length];
		String[] majors = new String[hakbuns.length];
		String[] phones = new String[majors.length];
		
		//3.무한반복을 통해서 메뉴를 만들고 메서드를 호출
		while(true) {	//무한반복
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
				//학생 등록 메서드 호출 call by reference
				input(names, hakbuns, majors, phones, sc);
				break;
			case 2 :
				//등록 학생 전체 출력 메서드 호출 call by reference
				output(names, hakbuns, majors, phones);
				break;
			case 3 :
				//학생 조회 메서드 호출
				search(names, hakbuns, majors, phones, sc);
				break;
			case 4 :
				//학생 정보 수정 메서드 호출
				update(hakbuns, majors, phones, sc);
				break;
			case 5 :
				//프로그램 종료 메서드 호출
				end = end(sc);
				break;
			}	//switch~case문 end
			
			if(end.equalsIgnoreCase("Y")) {
				break;
			}
			
		}//while 반복문 end
		
	}
}
