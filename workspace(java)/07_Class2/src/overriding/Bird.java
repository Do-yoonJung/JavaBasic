package overriding;

public class Bird extends Flyer {
	
	@Override
	void takeOff() {
		System.out.println("새가 날아오른다.");
	}
	
	@Override
	void fly() {
		System.out.println("새가 하늘을 날아다닌다.");
	}
	
	@Override
	void land() {
		System.out.println("새가 나뭇가지에 앉는다.");
	}

}
