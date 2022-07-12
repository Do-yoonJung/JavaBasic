package khie;

//[문제] for 반복문을 이용하여 1~100까지의 홀수의 합과 짝수의 합을 구하여 화면에 출력

public class Ex28 {

	public static void main(String[] args) {
		
		int oddSum = 0, evenSum = 0;
		
		for(int num = 1; num <= 100; num++) {
			if((num % 2) == 1) {
				oddSum += num;
			}else {
				evenSum += num;
			}
		}
		System.out.println("홀수의 합: " + oddSum);
		System.out.println("짝수의 합: " + evenSum);
	}
}