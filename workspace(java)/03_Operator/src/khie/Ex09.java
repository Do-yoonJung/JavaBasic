package khie;

// 키보드로부터 두 개의 숫자를 입력 받자
// 입력 받은 두수를 이용하여 산술연산을 진행해보자.
public class Ex09 {

	public static void main(String[] args) {
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		System.out.println(num1 % num2);
	}

}
