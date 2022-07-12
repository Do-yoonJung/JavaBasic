package khie;

public class Doit_123p_3 {

	public static void main(String[] args) {
		
		for(int i=1; i < 10; i++) {
			for(int j=1; j<10; j++) {
				if(j > i) break;
				System.out.println(i + "X" + j + "=" + (i*j));
			}
		}

	}

}
