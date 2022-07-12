package khie;

/*
 * 아래와 같이 화면에 출력을 해보자.
 * 
 * 	*****
 * 	*****
 * 	*****
 * 	*****
 * 
 * *
 * **
 * ***
 * ****
 * *****
 * 
 * *****
 * ****
 * ***
 * **
 * *
 */

public class Ex32 {

	public static void main(String[] args) {

		for(int i=1; i<=4; i++) {
			for(int j=1; j<6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		for(int i=1; i<6; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}