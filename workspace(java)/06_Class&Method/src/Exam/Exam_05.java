package Exam;

import java.util.Scanner;

public class Exam_05 {
	
	public static final double TAX_RATE = 1.1;	//static 상수
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메뉴는 몇 개인가요?: ");
		
		Receipt[] receipts = new Receipt[sc.nextInt()];
		
		//메뉴와 단가, 수량을 키보드로 입력 받아 객체 배열에 저장
		for(int i=0; i<receipts.length; i++) {
			System.out.println((i+1) + "번째 메뉴의 품명, 단가, 수량을 입력하세요.");
			receipts[i] = new Receipt(sc.next(), sc.nextInt(), sc.nextInt());
		}
		
		System.out.println();
		
		int totalPrice = 0;		//총금액 변수
		
		System.out.println("====================================");
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("====================================");
		
		for(int i=0; i<receipts.length; i++) {
			System.out.printf("%s\t%,d\t%,d\t%,d원\n", receipts[i].name, 
					receipts[i].unitPrice, (receipts[i].unitPrice*receipts[i].amount));
			totalPrice += (receipts[i].unitPrice*receipts[i].amount);
		}
		
		//공급가액 ==> 총금액(totalPrice) / 부가세액
		int supplyPrice = (int)(totalPrice / Exam_05.TAX_RATE);
		
		//부가세액 ==> 총금액 - 공급가액
		int vat = totalPrice - supplyPrice;
		
		System.out.println("====================================");
		System.out.printf("공급가액\t\t\t%,d원\n", supplyPrice);
		System.out.printf("부가세액\t\t\t%,d원\n", vat);
		System.out.println("====================================");
		System.out.printf("청구금액\t\t\t%,d원\n", totalPrice);
		
		sc.close();
	}
}
