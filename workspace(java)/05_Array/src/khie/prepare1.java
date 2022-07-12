package khie;

import java.util.Scanner;

public class prepare1 {
	public static void main(String[]args) {
		
		//내림차순
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력해주세요: ");
		int[] array = new int[sc.nextInt()]; 
		
		for(int i=0; i<array.length; i++) {
			System.out.print((i+1) + "번째 숫자를 입력하세요: ");
			array[i] = sc.nextInt();
		}
		
		int temp = 0;
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[j] > array[i]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		
		sc.close();
	}
	
	
}
