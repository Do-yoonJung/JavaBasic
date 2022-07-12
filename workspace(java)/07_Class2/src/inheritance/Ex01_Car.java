package inheritance;

public class Ex01_Car {

	public static void main(String[] args) {

		/*
		 * Sonata 클래스의 객체 생성 과정
		 * Sonata 클래스의 객체 생성 시에 JVM이 우선적으로 Car 부모클래스의 객체를 생성한 후에 
		 * 그 다음에 Sonata 클래스의 객체를 생성함
		 */
		
		//상속 후에는 자식클래스로 객체 생성
		Sonata sonata = new Sonata();
		
		sonata.output();
		
		System.out.println();
		
		sonata.model = "소나타";
		sonata.cc = 2000;
		sonata.door = 4;
		
		sonata.output();
	}

}
