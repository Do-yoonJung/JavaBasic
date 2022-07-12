package overriding;

public class Line extends Shape {
	
	@Override
	void draw() {
		//super.draw();
		System.out.println("선을 그리다.");
	}
}
