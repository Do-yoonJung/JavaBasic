package khie;

import java.util.Scanner;

public class prepare {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력해주세요: ");
		
		int[] array = new int[sc.nextInt()];
		int temp = 0;
		
		for(int i=0; i<array.length; i++) {
			System.out.print((i+1) + " 번째 숫자를 입력해주세요: ");
			array[i] = sc.nextInt();
		}
		
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < array[i]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		
		System.out.println("배열의 크기를 입력해주세요: ");
		
		int[] arr = new int[sc.nextInt()];
		int tem = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1) + " 번째 숫자를 입력해주세요: ");
			arr[i] = sc.nextInt();
		}
		
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] > arr[i]) {
					tem = arr[j];
					arr[j] = arr[i];
					arr[i] = tem;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		sc.close();
		
		
	}
	
}
