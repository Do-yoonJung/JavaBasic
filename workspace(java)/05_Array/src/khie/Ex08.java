package khie;

import java.util.Scanner;

/*
 * 배열에 데이터를 저장
 * 	내림차순으로 정렬하는 방법
 * 	예) 19,43,6,97,65 ==> 97,65,43,19,6
 */

public class Ex08 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수형 배열의 크기 입력: ");
		
		int[] score = new int[sc.nextInt()];
		
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1) + " 번째 정수 입력: ");
			
			score[i] = sc.nextInt();
		}
		
		//내림차순으로 정렬을 진행
		
		int temp = 0;
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(score[j] > score[i]) {
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		
		for(int i=0; i<score.length; i++) {
			System.out.println("score[" + i + "]: " + score[i]);
		}
		
		sc.close();
		
	}
}
