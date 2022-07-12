package polymorphism;

public class Ex01_Animal {

	public static void main(String[] args) {

		Animal dog = new Dog();
		
		//Dog dog2 = new Animal();		//Err
		
		dog.sound();
		//dog.output();					//Err 자식개체에서 만든 멤버들에는 접근 불가 
		
	}

}
