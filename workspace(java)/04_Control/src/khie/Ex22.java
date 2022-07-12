package khie;

//1~100까지의 홀수의 합과 짝수의 합을 구해보자.

public class Ex22 {

	public static void main(String[] args) {

		//홀수의 합 변수, 짝수의 합 변수
		int oddSum = 0, evenSum = 0;
		
		//반복문에서의 초기식
		int num = 1;
		
		while(num <= 100) {
			if((num % 2) == 1) {
				oddSum = oddSum + num;
			}else {
				evenSum = evenSum + num;
			}
			num++;
		}	// while 반복문 end
		
		System.out.println("홀수의 합: " + oddSum);
		System.out.println("짝수의 합: " + evenSum);
	}
}