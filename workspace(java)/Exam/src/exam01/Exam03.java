package exam01;

public class Exam03 {
	public static void main(String[] args) {
		
		int money = Integer.parseInt(args[0]);	//지불 금액
		int price = Integer.parseInt(args[1]);	//단가
		int amount = Integer.parseInt(args[2]);	//수량
		int sum = price * amount;				//단가*수량
		int vat = (int)(sum * 0.1);				//부가세
		int total = sum + vat;					//총액
		int change = money - total;				//거스름 돈
		
		System.out.println("지불한 금액 : " + money + "원");
		System.out.println("제품단가 : " + price + "원");
		System.out.println("수량 : " + amount);
		System.out.println("부가세 : " + vat + "원");
		System.out.println("상품총액 : " + total + "원");
		System.out.println("거스름 돈 : " + change + "원");
	}
}
