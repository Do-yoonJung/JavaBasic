package khie;

public class Doit_123p_2 {

	public static void main(String[] args) {
		
		// 짝수 구구단 출력
		for(int i=1; i<10; i++) {
			if(i % 2 != 0) continue;
			for(int j=1; j<10; j++) {
				System.out.println(i + "X" + j + "=" + (i*j));
			}
		}

	}

}
