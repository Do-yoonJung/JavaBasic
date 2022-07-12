package method;

import java.util.Scanner;

//개인별 성적 처리 - 무한반복

public class Ex11 {
	
	public static int total(int k, int e, int m) {
		
		return k + e + m;
	}

	public static double average(int tot) {
		
		return tot / 3.0;
	}
	
	public static String score(double avg) {
		
		String grade = "";
		
		if(avg >= 90) {
			grade = "A학점";
		}else if(avg >= 80) {
			grade = "B학점";
		}else if(avg >= 70) {
			grade = "C학점";
		}else if(avg >= 60) {
			grade = "D학점";
		}else {
			grade = "F학점";
		}
		
		return grade;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//for문 무한반복 : for( ; ; ) {  }
		while(true) {	//무한반복
			
			//키보드로 이름, 국어점수, 영어점수, 수학점수를 입력 받기
			System.out.print("이름 입력: ");
			String name = sc.next();
					
			System.out.print("국어점수 입력: ");
			int kor = sc.nextInt();
			
			System.out.print("영어점수 입력: ");
			int eng = sc.nextInt();
			
			System.out.print("수학점수 입력: ");
			int math = sc.nextInt();
			
			System.out.println();
			
			//총점 메서드 호출
			int sum = total(kor, eng, math);
			
			//평균 메서드 호출
			double avg = average(sum);
			
			//학점 메서드 호출
			String grade = score(avg);
			
			//성적을 화면에 출력
			System.out.println("이름: " + name);
			System.out.println("국어점수: " + kor + "점");
			System.out.println("영어점수: " + eng + "점");
			System.out.println("수학점수: " + math + "점");
			System.out.println("총점: " + sum + "점");
			System.out.printf("평균: %.2f\n", avg);
			System.out.println("학점: " + grade);
			System.out.println(":::::::::::::::::::::::::::::::::::");
			System.out.println();
			
			//계속 진행할지 종료를 할지 여부를 선택
			System.out.println("계속할까요?(Y:계속 / N:종료) : ");
			String res = sc.next();
			
			
			// equalsIgnoreCase() : 대소문자를 구분하지 않는 메서드
			if(res.equalsIgnoreCase("N")) {
				break;
			}
			
		}	//while 반복문 end
		System.out.println("수고하셨습니다.");
		sc.close();
	}

}
