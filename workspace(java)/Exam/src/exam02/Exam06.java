package exam02;

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {

		//1. 메뉴 선택, 수량, 입금액 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 아메리카노 - 3,000원");
		System.out.println("2. 카페라떼 - 4,000원");
		System.out.println("3. 마키아또 - 4,500원");
		System.out.println("4. 바닐라라떼 - 4,500원");
		System.out.print("위 메뉴 중 하나를 선택하세요. : ");
		
		int choice = sc.nextInt();
		
		System.out.print("주문수량 >> ");
		int amount = sc.nextInt();
		
		System.out.print("입금액 >> ");
		int money = sc.nextInt();
		
		// 결과 출력
		
		String coffee = "";
		int price = 0;
		
		switch(choice) {
		case 1:
			coffee = "아메리카노";
			price = 3000;
			break;
		case 2:
			coffee = "카페라떼";
			price = 4000;
			break;
		case 3:
			coffee = "마키아또";
			price = 4500;
			break;
		case 4:
			coffee = "바닐라라떼";
			price = 4500;
			break;
		}
		
		int sum, vat, total, change;
		sum = price * amount;
		vat = (int)(sum * 0.1);
		total = sum + vat;
		change = money - total;
		
		System.out.println("주문한 메뉴 : " + coffee);
		System.out.println("커피단가 : " + price + "원");
		System.out.println("주문수량 : " + amount);
		System.out.println("입금액 : " + money + "원");
		System.out.println("총금액 : " + total + "원");
		System.out.println("거스름 돈 : " + change + "원");

		sc.close();
	}
}
