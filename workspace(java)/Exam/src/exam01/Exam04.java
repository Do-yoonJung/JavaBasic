package exam01;

public class Exam04 {
	
	public static void main(String[] args) {
		
	
	int num = Integer.parseInt(args[0]);
	
	int oc, c, ob, b, os, s, i, res;
	
	oc = num / 5000;
	res = num % 5000;
	
	c = res / 1000;
	res = res % 1000;
	
	ob = res / 500;
	res = res % 500;
	
	b = res / 100;
	res %= 100;
	
	os = res / 50;
	res %= 50;
	
	s = res / 10;
	res %= 10;
	
	i = res / 1;
	res %= 1;
	
	System.out.println("입력받은 숫자 ==> " + num);
	System.out.println("오천원 지폐 : " + oc + "장");
	System.out.println("천원 지폐 : " + c + "장");
	System.out.println("오백원 동전 : " + ob + "개");
	System.out.println("백원 동전 : " + b + "개");
	System.out.println("오십원 동전 : " + os + "개");
	System.out.println("십원 동전 : " + s + "개");
	System.out.println("일원 동전 : " + i + "개");
	}
}
