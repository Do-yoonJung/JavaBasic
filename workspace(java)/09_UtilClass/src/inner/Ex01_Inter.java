package inner;

/*
 * 다양한 형태의 클래스 선언 방법
 * 1. 일반적인 선언 방법
 *    ==> 하나의 java파일에 class 키워드를 작성하여 클래스 선언.
 * 2. 무명 클래스(anonymous class) 선언
 *    ==> 이름이 없는 클래스 선언. interface 객체 생성시 많이 사용됨.
 * 3. 중첩 클래스(inner class) 선언
 *    ==> 클래스 안에 또 다른 클래스 선언
 */

public class Ex01_Inter {
	
	public static void main(String[] args) {
		
		//1. 일반적인 선언 방법
		//Sub 객체 생성
		Sub sub = new Sub();
		
		System.out.println("sum() 메서드 호출: " + sub.sum(200, 15));
		System.out.println("minus() 메서드 호출: " + sub.minus(127, 15));
		System.out.println();
		
		//2. 무명 클래스(anonymous class) 선언
		Inter inter = new Inter() {
			
			@Override
			public int sum(int n1, int n2) {
				return n1 + n2;
			}
			
			@Override
			public int minus(int n1, int n2) {
				return n1 - n2;
			}
		};
		
		System.out.println("sum() 메서드 호출: " + inter.sum(200, 15));
		System.out.println("minus() 메서드 호출: " + inter.minus(127, 15));
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
