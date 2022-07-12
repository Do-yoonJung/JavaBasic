package method;

import java.util.Scanner;

public class Ex08 {

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
		}else if(avg>=80) {
			grade = "B학점";
		}else if(avg>=70) {
			grade = "C학점";
		}else if(avg>=60) {
			grade = "D학점";
		}else {
			grade = "F학점";
		}
		
		return grade;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//1. 키보드로 이름, 국어점수, 영어점수, 수학점수를 입력 받기
		System.out.print("이름을 입력하세요: ");
		String name = sc.next();
		
		System.out.print("국어점수 입력: ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수 입력: ");
		int eng = sc.nextInt();
		
		System.out.print("수학점수 입력: ");
		int math = sc.nextInt();
		
		//2. 총점 메서드를 호출
		int sum = total(kor, eng, math);
		
		//3. 평균 메서드를 호출
		double avg = average(sum);
		
		//4. 학점 메서드를 호출
		String grade = score(avg);

		//5. 화면에 성적을 출력
		
		System.out.println("이름: "+ name);
		System.out.println("국어점수: "+ kor + "점");
		System.out.println("영어점수: "+ eng + "점");
		System.out.println("수학점수: "+ math + "점");
		System.out.println("총점: "+ grade + "점");
		System.out.printf("평균: %.2f점\n", avg);
		
		sc.close();
		
	}
}















