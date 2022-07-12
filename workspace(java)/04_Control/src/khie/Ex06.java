package khie;

/*
 * if~else문 - 조건문(분기문)
 * 	조건식이 참이면 조건식이 참인 경우 실행문장을 실행하고 if~else 블럭을 빠져 나옴
 * 	조건식이 거짓이면 조건식이 거짓인 경우 실행문장을 실행하고 if~else 블럭을 빠져 나옴
 * 
 * 		형식)
 * 			if(조건식) {
 * 					조건식이 참인 경우 실행 문장;
 * 				}else {
 * 					조건식이 거짓인 경우 실행 문장;
 * 				}
 */

public class Ex06 {

	public static void main(String[] args) {
		
		int su = 20;
		
		if(su >= 50) {
			//조건식이 참인 경우 실행 문장
			System.out.println("입력 받은 수는 50 이상의 숫자입니다.");
		}else {
			//조건식이 거짓인 경우 실행 문장
			System.out.println("입력 받은 수는 50 이하의 숫자입니다.");
		}
	}
}