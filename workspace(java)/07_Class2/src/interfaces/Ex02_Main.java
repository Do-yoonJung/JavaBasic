package interfaces;

interface Inter1{
	
	void aa();
}

interface Inter2{
	
	void bb();
}

//인터페이스들끼리 상속을 받을 때는 extends 키워드를 사용함
//일반적으로 클래스에서 상속은 단일 상속만 가능함. 하지만 인터페이스는 다중 상속이 가능함.
//implements는 class에서 interface를 상속 받을 때
interface Inter3 extends Inter1, Inter2{
	
	//void aa();		//상속이 된 추상메서드
	//void bb();		//상속이 된 추상메서드
	void cc();
}

class Total implements Inter3{

	@Override
	public void aa() {

		System.out.println("aa() 추상메서드 재정의");
	}

	@Override
	public void bb() {
		System.out.println("bb() 추상메서드 재정의");
		
	}

	@Override
	public void cc() {
		System.out.println("cc() 추상메서드 재정의");
		
	}
	
}

public class Ex02_Main {

	public static void main(String[] args) {

		Total total = new Total();
		
		total.aa(); total.bb(); total.cc();
	}

}
