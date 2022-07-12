package overriding;

public class Ex02_Shape {

	public static void main(String[] args) {

		Line line = new Line();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		
		line.draw();
		circle.draw();
		rectangle.draw();
	}

}
