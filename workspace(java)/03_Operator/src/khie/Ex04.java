package khie;

/*
 * 4. 단항연산자 / 이항연산자 / 3항연산자
 * 		단항연산자: 1개의 항을 대상으로 연산을 수행
 * 		이항연산자: 2개의 항을 대상으로 연산을 수행 
 * 		3항연산자: 3개의 항을 대상으로 연산을 수행
 */
public class Ex04 {
	public static void main(String[] args) {
		
		// 단항연산자(++, --)
		int su1 = 10, su2=10;
		System.out.println("su1++: " + su1++); //su1 출력 후 하나 증가
		System.out.println("++su2: " + ++su2); //하나 증가 후 출력
		
		/*
		 * 전위연산자: 단항연산자가 변수명 앞에 온다 (++x), 변수의 값을 하나 증가 또는 감소시킨 후 처리한다.
		 * 후위연산자: 단항연산자가 변수명 뒤에 온다(x++), 변수를 처리한 후 값을 하나 증가 또는 감소시킨다.
		 */
		
		int su3 = 10, su4 =20;
		System.out.println(++su3 + su4++);
		
		System.out.println((++su3 % 3) + (su3 * ++su4));
		
		/*
		 * 3항연산자
		 * 	형식)
		 * 		(조건) ? 수식1 : 수식2;
		 * 					==> 수식1: 해당 조건이 참인 경우 실행 문장
		 * 					==> 수식2: 해당 조건이 거짓인 경우 실행 문장
		 * 간단하게 조건문을 대신하여 사용할 수 있는 연산자
		 */
		
		int num1 = 45, num2 = 23;
		
		// String 자료형은 문자열을 저장할 때 사용하는 자료형
		String result = (num1 > num2) ? "num1 값이 크다" : "num2 값이 크다";
		System.out.println(result);
	}
}




















