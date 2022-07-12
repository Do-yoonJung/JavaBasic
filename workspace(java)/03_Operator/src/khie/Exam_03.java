package khie;

/*
 * [문제] 키보드로부터 상품명과 해당 상품의 단가, 수량, 입금액을 입력을 받아서 
 * 상품금액(단가 * 수량)과 부가세액(상품금액의 10%), 상품총금액(상품금액 + 부가세액)과 잔액을 구하여 화면에 출력해 보자.
 */

public class Exam_03 {
	public static void main(String[] args) {
		
		//1-1. 키보드로부터 상품명을 입력 받기
		String product = args[0];
		
		//1-2. 키보드토부터 해당 상품의 단가를 입력 받자
		int danga = Integer.parseInt(args[1]);
		
		//1-3. 키보드로부터 해당 상품의 수량을 입력 받기
		int amount = Integer.parseInt(args[2]);
		
		//1-4. 키보드로부터 입금액 입력 받기
		int money = Integer.parseInt(args[3]);
		
		//2. 상품금액 계산 (단가 * 수량)
		int sum = danga * amount;
		
		//3. 상품금액의 부가세액을 계산 (상품금액 * 0.1)
		int vat = (int)(sum * 0.1);
		
		//4. 상품의 총금액의 계산 (상품금액 + 부가세액)
		int total = sum + vat;
		
		//5. 잔액 계산 (입금액 - 상품총금액)
		int change = money - total;
		
		//6. 화면에 해당 내역을 출력
		System.out.println("상품명: " + product);
		System.out.printf("상품단가: %,d원\n", danga);
		System.out.println("상품수량: " + amount);
		System.out.printf("입금액: %,d원\n", money);
		System.out.printf("상품금액: %,d원\n", sum);
		System.out.printf("부가세액: %,d원\n", vat);
		System.out.printf("총금액: %,d원\n", total);
		System.out.printf("잔액: %,d원\n", change);
	}
}