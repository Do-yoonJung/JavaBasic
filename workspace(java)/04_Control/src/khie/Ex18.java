package khie;

import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		//1. 키보드로 이름, 과목별 점수 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("국어점수: ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수: ");
		int eng = sc.nextInt();	
		
		System.out.print("수학점수: ");
		int math = sc.nextInt();	
		
		System.out.print("자바점수: ");
		int java = sc.nextInt();	
		
		//2. 총점
		int sum = kor + eng + math + java;
		System.out.println("총점: " + sum);
		
		//3. 평균
		double avg = sum / 4.0;
		System.out.printf("평균: %.2f\n", avg);
		
		//4. 학점
		String grade; 	// 학점을 저장할 변수
		
		switch((int)(avg / 10)) {
		case 10,9 :
			grade = "A학점";
			break;
		case 8 :
			grade = "B학점";
			break;
		case 7 :
			grade = "C학점";
			break;
		case 6 :
			grade = "D학점";
			break;
		default :
			grade = "F학점";
		}
		
		//5. 성적 출력
		System.out.println("이름: " + name);
		System.out.println("국어점수: " + kor + "점");
		System.out.println("영어점수: " + eng + "점");
		System.out.println("수학점수: " + math + "점");
		System.out.println("자바점수: " + java + "점");
		System.out.println("총점: " + sum + "점");
		System.out.printf("평균: %.2f\n", avg);
		System.out.println("학점: " + grade);
		
		sc.close();
	}
}