package exam07_2;

public class Circle implements Shape{

	private int radius;
	
	public Circle(){}
	
	public Circle(int radius){
		this.radius = radius;
	}
	
	@Override
	public double findArea() {
		return radius*radius*3.14;
	}

}
