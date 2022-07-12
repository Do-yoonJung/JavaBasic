package Class;

public class Doit_138p {
	
	int num1;
	int num2;
	int result;
	
	public Doit_138p() { }
	
	public int add(int num1, int num2) {
		result = num1 + num2;
		return result;
	}
	
	public int minus(int num1, int num2) {
		result = num1 - num2;
		return result;
	}
	
	public int multiple(int num1, int num2) {
		result = num1 * num2;
		return result;
	}
	
	public int divide(int num1, int num2) {
		result = num1 / num2;
		return result;
	}
	
	public static void main(String[] args) {
		Doit_138p functionTest = new Doit_138p();
		
		int result = functionTest.add(1, 1);
		System.out.println(result);
		
		result = functionTest.minus(1, 1);
		System.out.println(result);
		
		result = functionTest.multiple(1, 5);
		System.out.println(result);
		
		result = functionTest.divide(10, 5);
		System.out.println(result);
		
	}
}
