package overriding;

public class Airplane extends Flyer {
	
	@Override
	void takeOff() {
		System.out.println("비행기가 이륙한다.");
	}

	@Override
	void fly() {
		System.out.println("비행기가 하늘을 난다.");
	}
	
	@Override
	void land() {
		System.out.println("비행기가 공항에 착륙한다.");
	}
	
}
