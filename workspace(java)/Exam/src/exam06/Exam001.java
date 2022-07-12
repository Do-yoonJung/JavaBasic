package exam06;

import java.util.Scanner;

class Product{
	String name;
	int price;
	int amount;
	
	public Product() {}
	
	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
}

public class Exam001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력받아 배열에 저장
		System.out.println("메뉴는 몇 개인가요?");
		Product[] Products = new Product[3];
		for(int i=0; i<Products.length; i++) {
			System.out.println("품명, 단가, 수량을 입력해주세요.");
			Products[i] = new Product(sc.next(), sc.nextInt(), sc.nextInt());
		}
		
		int[] goldPrice = new int[3];
		int totalGoldPrice =0;
		for(int i=0; i<goldPrice.length; i++) {
			goldPrice[i] = Products[i].price * Products[i].amount;
			totalGoldPrice += goldPrice[i];
		}
		int supply = (int)(totalGoldPrice / 1.1);
		int tax = totalGoldPrice - supply;
		int eventually = supply + tax;
		
		//영수증 출력 화면
		System.out.println("********** 영수증 **********");
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("================================");
		
		for(int i=0; i<3; i++) {
			System.out.printf("%S\t%d\t%d\t%,d원\n", Products[i].name,Products[i].price,
					Products[i].amount,goldPrice[i]);
		}
		System.out.println("================================");
		System.out.printf("공급가액\t\t\t%,d원\n", supply);
		System.out.printf("부가세\t\t\t%,d원\n", tax);
		System.out.println("================================");
		System.out.printf("청구금액\t\t\t%,d원\n", eventually);
		
		sc.close();
	}
}
