package exam01;

public class Exam02 {
	public static void main(String[] args) {
		
		//임의의 정수 입력
		int num = Integer.parseInt(args[0]);
		
		System.out.println("입력받은 정수 ==> " + num);
		System.out.println(num + "의 제곱 ==> " + num*num);
		System.out.println(num + "의 세제곱 ==> " + num*num*num);
	}
}
