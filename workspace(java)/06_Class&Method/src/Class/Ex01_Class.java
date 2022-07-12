package Class;

/*
 * 객체(Object)?
 * 	-실 세계에서 우리 주변에 있는 모든 것이 객체임
 * 	예) TV, 컴퓨터, 책, 건물, 의자, 사람 등등
 * 	-실 세계의 객체들은 자신만의 고유한 특성(속성)과 행동(기능)을 가지고 있음
 * 	-이러한 객체들은 다른 객체들에게 행동을 요청하거나 정보를 주고 받는 등 상호 작용을 하면서 존재함
 * 	예를 든다면사람은 전자계산기의 기능을 이용하게 되고, 전자계산기는 계산 결과를 사람에게 알려주는 상호 작용을 하게 됨.
 * 	-이러한 객체는 속성과 동작(기능)으로 구성이 되어있음
 *  예를 든다면 사람은 이름, 나이 등의 속성이 있고, 걷다, 쓰다, 달린다 등의 동작이 있음
 *  또한 자동차의 경우에는 색상, 모델명 등이 속성에 해당이 되고, 달린다, 멈춘다 등의 동작이 있음
 * 	-객체는 개별적으로 사용이 될 수도 있지만, 대부분 다른 객체와 관계를 맺고 있게 됨.
 * 	이러한 관계의 종류에는 집합관계, 사용관계, 상속관계가 있음 ==> 중요
 * 	-집합관계는 객체는 하나의 부품이고, 하나의 완성품에 해당이 됨
 * 	예를 든다면 자동차는 엔진, 타이어, 핸들 등으로 구성되므로 이 부품들을 집합관계로 볼 수 있음
 *  -사용관계는 객체 간의 상호작용을 말함. 다른 객체의 메서드를 호출하여 원하는 결과를 얻어내는 것을 말함.
 *  예를 든다면 사람은 자동차를 사용하므로 사람과 자동차는 사용의 관계라고 볼 수 있음
 *  사람은 자동차를 사용할 때 달린다, 멈춘다 등의 메서드를 호출함
 *  -상속관계는 상위(부모) 객체를 기반으로 하위(자식) 객체를 생성하는 관계를 말함
 *  일반적으로 상위 객체는 종류를 의미하고, 하위 객체는 구체적인 사물에 해당이 됨
 *  예를 든다면 "독수리는 새의 종류이다" 에서 새(상위)와 독수리(하위)는 상속관계에 있다고 볼 수 있음
 *  - 객체지향 프로그래밍(OOP: Object Oriented Programming)은 만들고자하는 완성품인 객체를 모델링하고,
 *  집합관계에 있는 부품객체와 사용관계에 있는 객체를 하나씩 설계한 후 조립하는 방식으로 프로그램을 개발하는 기법임
 * 
 * 클래스(Class)?
 * 	-현실에서 객체는 갑자기 만들어지는 것이 아니라, 설계도를 바탕으로 만들어짐
 * 	예를들어 사람들이 자동차를 이용하기 위해서는 우선 공장에서 설계도를 보고 자동차를 만들어야 함
 *  객체지향 프로그래밍에서도 마찬가지임. 메모리에서 사용하고 싶은 객체가 있다면
 *  우선 설계도로 해당하는 객체를 만드는 작업이 필요함.
 *  자바에서는 설계도가 바로 클래스(Class)임.
 *  -클래스는 객체를 만들기 위한 설계도(틀, 도면)임.
 *  -자바는 클래스 단위로 프로그래밍을 함
 *  -클래스를 구성하는 것을 멤버(member)라고 함
 *  -멤버 = 속성(멤버변수) + 기능(멤버메서드)
 *  		==> 속성: 멤버변수 - 클래스의 특징 ==> 명사적 개념
 *  		==> 기능: 멤버메서드 - 클래스의 행위(동작) ==> 동사적 개념
 *  -클래스의 구성: 클래스 헤더, 멤버변수, 멤버메서드, 생성자
 *  
 * [클래스 형식]
 * 				[접근제한] class 클래스 이름 {
 * 						멤버변수;
 * 						생성자();
 * 						멤버메서드();
 * 				}
 * 	-클래스 이름: 반드시 대문자로 시작(식별자)
 */

public class Ex01_Class {
	
	/*
	 * 멤버변수는 초기값을 설정하지 않으면 JVM이 객체생성 시점에 
	 * 해당 데이터 타입(자료형)에 맞게 알아서 해당 자료형의 default 값을 설정을 해줌
	 */
	
	int num;		//멤버변수 - 전역변수
	String str;		//멤버변수 - 전역변수
	
	void display() {	//멤버메서드
		
		int su = 10;	//지역변수
		
		System.out.println("멤버변수(num): " + num);
		System.out.println("멤버변수(str): " + str);
		System.out.println("지역변수(su): " + su);
	}
	

	public static void main(String[] args) {
		//클래스를 대상으로 객체를 만드는 과정이 필요함
		//1단계: 클래스를 선언
		//		형식) 클래스이름 참조변수;
		//				*참조변수: heap 메모리 공간에 객체가 만들어지는데 만들어지는 객체의 주소값을 가지는 놈
		//Ex01_Class ex;
		
		//2단계: 클래스를 메모리(heap)에 생성
		//		형식) 참조변수 = new 클래스이름(); ==> 클래스이름(X), 생성자(O)
		//ex = new Ex01_Class();
		
		//1단계 + 2단계: 클래스 선언 및 클래스 객체 생성
		Ex01_Class ex = new Ex01_Class();
		
		System.out.println("ex: " + ex);
		
		//3단계: 참조변수를 이용하여 객체에 접근
		//		객체에 접근 시 .(도트) 연산자를 이용하여 접근
		ex.display();
		System.out.println();
		
		ex.num = 150;
		ex.str = "홍길동";
		ex.display();
		System.out.println();
		
		Ex01_Class ex1 = new Ex01_Class();
		
		System.out.println("ex1: " + ex1);
		
		ex1.num = 235;
		ex1.str = "유관순";
		ex1.display();
		
	}

}
