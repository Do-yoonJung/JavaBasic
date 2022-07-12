package exam01;

public class Exam01 {
	public static void main(String[] args) {
		
		int kor = 80, eng = 85, math = 90, java = 70;
		int sum = kor + eng + math + java;
		double avg = sum/4.0;
		
		System.out.println("국어점수: " + kor + "점");
		System.out.println("영어점수: " + eng + "점");
		System.out.println("수학점수: " + math + "점");
		System.out.println("자바점수: " + java + "점");
		System.out.println("총   점: " + sum + "점");
		System.out.printf("평   균: %.2f점\n", avg);
	}
}
