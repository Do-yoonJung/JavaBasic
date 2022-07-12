package Class;

public class Ex10_Number {

	public static void main(String[] args) {

		Number number = new Number();
		//number.num1 = 50;	//Err
		number.setNum1(350);
		number.setNum2(170);
		
		System.out.println("num1: " + number.getNum1());
		System.out.println("num2: " + number.getNum2());
		
		
	}

}
