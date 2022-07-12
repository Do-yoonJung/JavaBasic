package Exam;

public class Receipt {
	
	//멤버변수
	String name;			//품명
	int unitPrice;			//단가
	int amount;				//수량
	
	public Receipt() {}		//기본생성자
	public Receipt(String name, int unitPrice, int amount) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.amount = amount;
	}	//인자생성자
}
