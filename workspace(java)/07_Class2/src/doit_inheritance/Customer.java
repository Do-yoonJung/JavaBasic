package doit_inheritance;

public class Customer {
	
	// 멤버 변수
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	// 디폴트 생성자
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "SILVER"; // 기본 등급
		bonusRatio = 0.01; // 기본 적립 비율
		// System.out.println("Customer() 생성자 호출");
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	// 포인트 적립, 지불 가격 계산 메서드
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	// 고객 정보 반환 메서드
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + 
				bonusPoint + "입니다.";
	}
	
}
