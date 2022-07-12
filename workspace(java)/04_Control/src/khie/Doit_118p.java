package khie;

public class Doit_118p {
	public static void main(String[] args) {
		
		// 구구단 3단부터 7단까지 출력
		for(int i=3; i<8; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i + "X" + j + "=" + (i*j));
			}
		}
		
		// continue 홀수의 합
		int num;
		int total = 0;
		for(num = 1; num <= 100; num++) {
			if(num % 2 == 0) {
				continue;
			}
			total += num;
		}
		
		System.out.println(total);
		
	}
}
