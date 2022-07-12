package inheritance;

public class Sonata extends Car {
	
	//int cc;			//상속을 받으면 부모클래스의 멤버는 생략
	//int door;
	String model;		//차량모델명
	
	void output() {
		System.out.println("모델명: " + model);
		System.out.println("배기량: " + cc);
		System.out.println("차량 문 수: " + door);
	}
}
