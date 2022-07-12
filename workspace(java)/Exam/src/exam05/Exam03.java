package exam05;

import java.util.Scanner;

class NameCard{
	String name;
	String phone;
	String address;
	String position;
	
	NameCard(String n, String ph, String a, String p){
		name = n;
		phone = ph;
		address = a;
		position = p;
	}
	
	void print() {
		System.out.println("====================================");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phone);
		System.out.println("주소: " + address);
		System.out.println("직급: " + position);
	}
}

public class Exam03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 전화번호, 주소, 직급을 입력하세요.");
		NameCard n1 = new NameCard(sc.next(),sc.next(),sc.next(),sc.next());
		
		n1.print();
		sc.close();
	}
}
