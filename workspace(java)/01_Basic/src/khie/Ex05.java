package khie;

public class Ex05 {

	public static void main(String[] args) {
		
		//숫자 + 숫자 ==> 숫자(+의 역할은 덧셈의 의미)
		System.out.println(10+2);
		
		//문자 + 숫자 ==> 문자(+의 역할은 연결(결합)의 의미
		System.out.println("10" + 2);
		
		//숫자 + 문자 ==> 문자(+의 역할은 연결(결합)의 의미
				System.out.println(10 + "2");
				
		//문자 + 문자 ==> 문자(+의 역할은 연결(결합)의 의미
		System.out.println("10" + "2");
		
		System.out.println("a >>> " + 10 + 2);	// a >>> 102
		System.out.println("a >>> " + (10 + 2));	// a >>> 12
		
	}

}
