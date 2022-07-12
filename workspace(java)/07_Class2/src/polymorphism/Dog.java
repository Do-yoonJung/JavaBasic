package polymorphism;

public class Dog implements Animal {
	
	@Override
	public void sound() {
		System.out.println("멍멍멍");
	}
	
	void output() {
		System.out.println("출력용 메서드입니다.");
	}
}
