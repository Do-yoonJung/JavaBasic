package abstracts;

/*
 * 추상 클래스(abstract class)?
 * 1. 추상 메서드를 포함하는 클래스.
 * 2. 추상 메서드는 본체(body)가 없는 메서드
 * 	  ==> 선언은 되어 있으나 코드가 구현되지 않은 껍데기만 있는 메서드를 말함.
 * 		  예) void display();		// {  } 가 없다.
 * 3. 클래스 앞에 abstract 키워드가 온다.
 * 4. 추상 메서드를 재정의하지 않으면 error 발생.
 * 	  ==> 추상 메서드 재정의 강제성.
 * 5. 추상 클래스는 객체 생성이 불가능
 * 	  ==> -자식 클래스를 대상으로 객체 생성
 * 		  -원칙적으로 자식클래스도 추상 클래스임.
 * 		   이유는 추상메서드를 그대로 상속을 받았기 때문임.
 * 		  -하지만 부모의 추상메서드를 재정의하게 되면 객체 생성이 가능함.
 * 6. 추상 클래스는 추상 메서드를 가진 클래스를 말함.
 * 7. 물론 일반 멤버(멤버변수, 멤버메서드)를 가질 수 있음.
 * 8. 그러나 한 개 이상의 추상메서드는 반드시 존재해야 함.
 * 		형식)
 * 				[접근제한] abstract class 클래스명 {  }
 * 9. 용도: -응용 프로그램에서 설계와 구현 부분을 분리해서 작업 시 사용됨.
 * 		   -추상 클래스를 책의 목차에 비유를 하면, 서브클래스는 목차에 따라 완성된 책과 같음.
 * 			책을 쓸 때도 목차를 잡아 놓고 책을 쓰면 훨씬 쉽고 빠르며 방향이 흐트러지지 않는 것처럼 
 * 			추상 클래스를 이용하면 응용 프로그램의 설계와 구현을 분리할 수 있음.
 * 		   -추상클래스로 기본 방향을 잡아 놓고 서브클래스에서 구현하면 구현 작업이 쉬워짐
 * 
 * 추상 클래스에서 error 발생 - 2가지
 * 1. 자식 클래스에서 추상 메서드를 재정의(O).
 * 2. 자식 클래스에서 재정의를 하지 않는 경우.
 * 	  ==> 자식 클래스 이름 앞에 abstract 키워드를 붙여야 함.
 * 
 * 
 */

public abstract class Super {	//추상 클래스
	
	int num1;		//인스턴스 멤버변수
	
	int clac() { 	//인스턴스 멤버메서드
		int sum = num1 + 100;
		return sum;
	}
	
	abstract void output();		//추상 메서드
	
}
