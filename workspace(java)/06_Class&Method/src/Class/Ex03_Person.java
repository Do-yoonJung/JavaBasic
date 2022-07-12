package Class;

public class Ex03_Person {	//클래스가 여러개여도 public는 하나만 존재한다 class Person 이렇게 선언

	public static void main(String[] args) {

		Person person = new Person();
		
		person.name = "홍길동";
		person.age = 27;
		person.display();
		System.out.println();
	}
}
