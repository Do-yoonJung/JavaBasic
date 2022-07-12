package khie;

public class Exam02_04 {

	public static void main(String[] args) {
		
		for(char c = 'Z'; c >= 'A'; c--) {
			for(char d='A'; d<=c; d++) {
				System.out.print(d);
			}
			System.out.println();
		}
	}
}
