package khie;

/*
 * [문제] 이름과 국어점수, 영어점수, 수학점수, 자바점수를 키보드로 입력을 받아서 성적을 처리해보자.
 * 		 총점, 평균까지 출력해보자.
 */
public class Exam_01 {

	public static void main(String[] args) {
		
		// 1. 키보드로 이름, 국어, 영어, 수학점수, 자바점수를 입력 받기
		String name = args[0];	// 이름을 키보드로 입력
		int kor = Integer.parseInt(args[1]);	// 국어점수를 키보드로 입력
		int eng = Integer.parseInt(args[2]);	// 영어점수를 키보드로 입력
		int math = Integer.parseInt(args[3]);	// 수학점수를 키보드로 입력
		int java = Integer.parseInt(args[4]);	// 자바점수를 키보드로 입력
		
		// 2. 총점
		int total = kor + eng + math + java;
		
		// 3. 평균
		double avg = total / 4.0; //정수를 정수로 나누면 정수가 나옴 한군데를 실수로 바꿔야 함
		//float avg = total / 4.0F; 4.0은 더블 타입이기 때문에 float를 하고 싶으면 F 붙여
		
		// 4. 출력
		System.out.println("이름: " + name);
		System.out.println("국어점수: " + kor +"점");
		System.out.println("영어점수: " + eng +"점");
		System.out.println("수학점수: " + math +"점");
		System.out.println("자바점수: " + java +"점");
		System.out.println("총점: " + total +"점");
		System.out.printf("평균: %.2f점\n", avg);
	}
}