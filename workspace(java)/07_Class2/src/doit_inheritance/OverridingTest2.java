package doit_inheritance;

public class OverridingTest2 {
	public static void main(String[] args) {
		Customer customerKim = new VIPCustomer(10020, "김유신", 12345);
		customerKim.bonusPoint = 1000;
		
		int price = 10000;
		System.out.println(customerKim.getCustomerName() + "님이 지불해야 하는 금액은 " 
				+ customerKim.calcPrice(price) + "원 입니다.");
	}
}
