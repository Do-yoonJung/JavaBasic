package exam02;

import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("지방의 그램을 입력하세요 : ");
		int fat = sc.nextInt();
		System.out.print("탄수화물의 그램을 입력하세요 : ");
		int cab = sc.nextInt();
		System.out.print("단백질의 그램을 입력하세요 : ");
		int pro = sc.nextInt();		
		
		fat *= 9;
		cab *= 4;
		pro *= 4;
		
		int total = fat + cab + pro; 
		
		System.out.printf("총칼로리 : %,d cal\n", total);
		
		sc.close();
	}
}
