package khie;

public class Ex06 {
	public static void main(String[] args) {
		
		// System.out.printf()
		// 형식에 맞게 출력하는 메서드. d: 정수, o: 8진수 x: 16진수 s: 문자열 출력
		System.out.printf("%,d\n", 1000000); //,넣은 수 출력
		System.out.printf("%2d\n", 1); // 정수를 두 자리로 출력
		System.out.printf("%2d\n", 10);
		System.out.printf("%o\n", 10);
		System.out.printf("%x\n", 10);
		System.out.printf("%s\n", "문자열 출력");
		
		// 형식("%전체자릿수.소수점자릿수.f)
		// ==> 즉, 정수는 그대로 출력이되고, 소숫점 아래는 2자리까지 표현.
		System.out.printf("%f\n", 3.2582); //소수점 아래 6자리까지
		System.out.printf("%4.2f\n", 3.2582); //전체 4자리 소숫점 아래 2자리 반올림하여 출력
		System.out.printf("%.3f\n", 3.2582); //소숫점 아래 3자리 반올림하여 출력
	}
}
