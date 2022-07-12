package khie;

/*
 * 2. 반목문
 * 		반복해서 실행할 때 사용하는 문장
 * 		반복문의 종류: while문, do~while문, for문
 * 
 * while 반복문
 * 	조건식을 비교하여 참인 경우 계속해서 반복 실행문을 실행하고, 조건식이 거짓인 경우에는 반복문을 빠져 나가는 문장
 * 	while 반복문은 반복문의횟수를 알 수 없는 경우에 많이 사용된다.
 * 	반복문에는 반드시 초기식, 조건식, 증감식이 존재해야 함.
 * 
 * 		형식)
 * 			while(조건식) {
 * 				반복 실행 문장;
 * 			}
 * 
 * do~while 반복문
 * 	먼저 반복 실행문을 실행하고 조건식을 비교함
 * 	
 * 		형식)
 * 			do {
 * 				반복 실행 문장;
 * 			}while(조건식);
 */

public class Ex19 {

	public static void main(String[] args) {
		
		//순수하게 출력 문장을 이용하여 1~10까지 출력한 코드
		System.out.println("su >>> " + 1);
		System.out.println("su >>> " + 2);
		System.out.println("su >>> " + 3);
		System.out.println("su >>> " + 4);
		System.out.println("su >>> " + 5);
		System.out.println("su >>> " + 6);
		System.out.println("su >>> " + 7);
		System.out.println("su >>> " + 8);
		System.out.println("su >>> " + 9);
		System.out.println("su >>> " + 10);
		
		System.out.println();
		
		//while 반복문을 이용하여 1~10 출력
		int num = 1;	//반복문에서의 초기식
		
		while(num <= 10) {	//반복문에서의 조건식
			System.out.println("num: " + num);
			num++;			//반복문에서의 증감식
		}
		
		System.out.println();
		
		//do~while 반복문을 이용하여 1~10까지 출력 (거짓이어도 한번은 실행됨)
		int number = 1;
		
		do {
			System.out.println("number: " + number);
			number++;
		}while(number <=10);
	}
}