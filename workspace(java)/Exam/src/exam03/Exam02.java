package exam03;

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		
		// 임의의 숫자 5개를 키보드로 입력 받아
		Scanner sc = new Scanner(System.in);
		System.out.println("5개의 숫자를 입력하세요");
		
		int[] arr = new int[5];
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//내림차순으로 정렬
		int temp;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]>arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("===내림차순으로 정렬===");
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		sc.close();
		
	}
}
