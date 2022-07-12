package khie;

import java.util.Scanner;

//[문제]키보드로 입력받은 수가지의 홀수의 합과 짝수의 합을 구하여 출력.(while반복문을 이용하여 처리)

public class Ex23 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int max = sc.nextInt();
		
		int oddSum = 0, evenSum = 0;
		int num = 1;
		
		while(num <= max) {
			if((num % 2) == 1) {
				oddSum += num;
			}else {
				evenSum += num;
			}
			num++;
		}
		
		System.out.println("1부터 " + max + "까지의 홀수의 합: " + oddSum);
		System.out.println("1부터 " + max + "까지의 짝수의 합: " + evenSum);
		
		sc.close();
	}
}