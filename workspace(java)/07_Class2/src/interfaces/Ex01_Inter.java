package interfaces;

public class Ex01_Inter {

	public static void main(String[] args) {

		//인터페이스는 객체 생성 불가능
		//Inter inter = new Inter();
		
		Sub sub = new Sub();
		
		//static final 상수로 인식을 함
		//상수 값을 변경하는 것은 불가능함
		//sub.num = 150;
		
		sub.output1();
		sub.output2();
		
	}

}
