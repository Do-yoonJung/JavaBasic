package khie;

/*
 * 3. 논리연산자
 * 		논리곱(&&): 주어진 조건이 모두 참일 때 결과가 true가 됨. 그 나머지는 모두 false
 * 		논리합(||): 주어진 조건 중 하나라도 참이면 결과는 true가 됨. 그 나머지는 false
 * 		부정(!): true -> false 가 되고, false -> true가 됨.
 * 		논리연산자는 우선적으로 관계연산자를 실행한 후에 그 결과값을 가지고 논리연산을 수행하게 됨.
 */
public class Ex03 {
	public static void main(String[] args) {
		
		int su1 = 10, su2 = 7;
		
		// 논리곱인 경우: true && true ==> true
		boolean test1 = (su1 >= su2) && (su1 >= 5);
		System.out.println("test1 결과: " + test1);
		
		// true && false ==> false
		test1 = (su1 >= su2) && (su1 <= 5);
		System.out.println("test1 결과: " + test1);
		
		// false && true ==> false
		test1 = (su1 <= su2) && (su1 >= 5);
		System.out.println("test1 결과: " + test1);
				
		// false && false ==> false
		test1 = (su1 <= su2) && (su1 <= 5);
		System.out.println("test1 결과: " + test1);
		
		
		
		// 논리합인 경우: true || true ==> true
		boolean test2 = (su1 >= su2) || (su1 >= 5);
		System.out.println("test2 결과: " + test2);
		
		// true && false ==> true
		test2 = (su1 >= su2) || (su1 <= 5);
		System.out.println("test2 결과: " + test2);
		
		// false && true ==> true
		test2 = (su1 <= su2) || (su1 >= 5);
		System.out.println("test2 결과: " + test2);
				
		// false && false ==> false
		test2 = (su1 <= su2) || (su1 <= 5);
		System.out.println("test2 결과: " + test2);
	}
}















