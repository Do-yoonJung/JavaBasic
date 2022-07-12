package exam02;

public class Exam04 {
	public static void main(String[] args) {
		
		for(char i='Z'; i>='A'; i--) {
			for(char j='A'; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
