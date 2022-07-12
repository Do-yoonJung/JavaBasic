package method;

// 메서드 호출 시 반환형

public class Ex07 {
	
	//반환되는 값이 일반 숫자(리터럴)이 반환이 되는 경우
	public static int method1() {
		
		return 155;
	}

	//반환되는 값이 변수가 반환이 되는 경우
	public static int method2(int su1, int su2) {
		
		int sum = (su1 * 2) + (su2 * 2);
		
		return sum;
		
	}
	
	//반환되는 값이 수식이 반환이 되는 경우
	public static int method3(int num1, int num2) {
		
		return num1 + num2;
		
	}
	
	//반환되는 값이 문자열이 반환이 되는 경우
	public static String method4() {
		
		return "홍길동";
	}
	
	//반환되는 값이 문자열 변수가 반환이 되는 경우
	public static String method5(String str1, String str2) {
		
		String result = str1 + str2;
		return result;
	}
	
	//반환되는 값이 문자열 결합(+) 수식이 반환이 되는 경우
	public static String method6(String s1, String s2) {
		
		return s1 + s2;
	}
	
	public static void main(String[] args) {

		//int su = method1();
		
		System.out.println("method1() 메서드 호출 후 반환 값: " + method1());
		
		System.out.println("method2() 메서드 호출 후 반환 값: " + method2(145, 200));
		
		System.out.println("method3() 메서드 호출 후 반환 값: " + method3(145, 200));
		
		System.out.println("method4() 메서드 호출 후 반환 값: " + method4());
		
		System.out.println("method5() 메서드 호출 후 반환 값: " + method5("대한", "민국"));
		
		System.out.println("method6() 메서드 호출 후 반환 값: " + method6("이", "순신"));
	}
}
