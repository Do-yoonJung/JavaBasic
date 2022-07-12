package khie;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달(월)을 입력하세요: ");
		
		int month = sc.nextInt();
		
		switch(month) {
			case 1,3,5,7,8,10,12 :
				System.out.println("마지막 날은 31일 입니다.");
				break;
			case 2 :
				System.out.println("마지막 날은 28일 입니다.");
				break;
			//이렇게 쓸 수도 있어
			case 4 :
			case 6 : 
			case 9 :
			case 11 :
				System.out.println("마지막 날은 30일 입니다.");
				break;
		}
		
		sc.close();
	}
}