package exam07_2;

public class Rectangle implements Shape{


	int length;
	int height;
	
	public Rectangle(){}
	
	public Rectangle(int length, int height) {
		this.length = length;
		this.height = height;
	}
	
	@Override
	public double findArea() {
		return length*height;
	}

}
