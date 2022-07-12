package exam07_2;

public class RectangleT implements Shape {

	int width;			//가로 변수
	int height;			//세로 변수
	
	public RectangleT(){}
	
	public RectangleT(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double findArea() {
		return width * height;
	}
	
}
