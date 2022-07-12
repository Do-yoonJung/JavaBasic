package abstracts;

public class Ex01_Super {

	public static void main(String[] args) {
		
		//추상 클래스는 객체 생성 불가능
		//Super super = new Super();
		
		Sub sub = new Sub();
		
		sub.num1 = 135;
		
		System.out.println("clac() 메서드 호출: " + sub.clac());

		sub.output(); 	//추상 메서드 재정의
	}

}
