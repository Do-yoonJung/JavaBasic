package exam03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열 크기: ");
		
		int[] arr = new int[sc.nextInt()];
		
		for(int i=0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 값 입력: ");
			arr[i] = sc.nextInt();
		}
		
		int temp;
		
		// 최대
		for(int i=0 ; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print("max: " + arr[0]);
		
		//최소
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print(", min: " + arr[0]);
		
		sc.close();
	}

}
