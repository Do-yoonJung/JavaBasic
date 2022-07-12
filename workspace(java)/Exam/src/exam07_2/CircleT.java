package exam07_2;

public class CircleT implements ShapeT {

	int radius;						//반지름 변수
	
	public CircleT() {}				//기본 생성자
	
	public CircleT(int radius) {	//인자 생성자
		this.radius = radius;
	}
	
	@Override
	public double findArea() {

		return 3.14 * radius * radius;
	}
	
}
