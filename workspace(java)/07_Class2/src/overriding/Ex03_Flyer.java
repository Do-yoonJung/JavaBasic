package overriding;

public class Ex03_Flyer {
	public static void main(String[] args) {
		
		Flyer flyer = new Flyer();
		Bird bird = new Bird();
		Airplane airplane = new Airplane();
		
		flyer.takeOff();
		flyer.fly();
		flyer.land();
		System.out.println();		
		bird.takeOff();
		bird.fly();
		bird.land();
		System.out.println();
		airplane.takeOff();
		airplane.fly();
		airplane.land();
	}
}
