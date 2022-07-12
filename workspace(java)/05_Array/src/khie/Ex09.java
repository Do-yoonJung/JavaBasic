package khie;

/*
 * 다차원 배열
 * 	1차원 배열이 여러개 묶여 있는 형태의 배열을 말함
 * 	행과 열의 개념이 적용됨
 */

public class Ex09 {
	public static void main(String[] args) {
		
		//다차원 배열 선언 및 메모리 생성
		int[][] arr = new int[3][4]; // 3행 4열의 다차원 배열
		
		int count = 10;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = count;
				count +=10;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.println("[" + i + "]" + "[" + j + "]" + arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		char[][] alpha = new char[2][13];
		char alphabet = 65;
		
		for(int i=0; i<alpha.length; i++) {
			for(int j=0; j<alpha[i].length; j++) {
				alpha[i][j] = alphabet;
				System.out.print(alpha[i][j] + " ");
				alphabet++;
			}
			System.out.println();
		}
	}
}
