package overriding;

public class Ex01_Animal {
	public static void main(String[] args) {

		Dog dog = new Dog();
		Cat cat = new Cat();
		Sheep sheep = new Sheep();		
		
		dog.sound();
		cat.sound();
		sheep.sound();
	}
}
