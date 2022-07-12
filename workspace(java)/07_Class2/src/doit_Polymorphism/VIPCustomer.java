package doit_Polymorphism;

public class VIPCustomer extends Customer{
	private int agentID; // VIP 고객 상담원 아이디
	double saleRatio; // 할인율
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		this.agentID = agentID;
		customerGrade = "VIP"; // ERR 상위 클래스에서 private -> protected
		bonusRatio = 0.05;
		saleRatio = 0.1;
		// System.out.println("VIPCustomer() 생성자 호출");
	}
	
	// 메서드 제정의
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio); // 할인된 가격을 반환
	}

	// 메서드 제정의
	public String showVIPInfo() {
		return super.showCustomerInfo() + "담당 상담원 아이디는 " + agentID + "입니다.";
	}
}
