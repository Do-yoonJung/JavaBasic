package Class;

//음료 자판기

//음료 6개 - 콜라, 사이다, 환타, 캔커피, 아침햇살, 옥수수수염차

//객체 배열

public class Drink {

	//멤버변수
	String name;	//음료 이름
	int price;		//음료 가격
	
	public Drink() {}	//기본 생성자
	
	public Drink(String n, int p) {
		name = n;
		price = p;
	}	//인자 생성자
}
