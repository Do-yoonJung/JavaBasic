package exam05;

import java.util.Scanner;

class Person {
	//1.멤버변수
	String name;
	String sex;
	int age;
	
	//2.생성자
	Person(String name, String sex, int age){
		this.name = name;
		switch(sex) {
		case "male":
			this.sex = "남자";
			break;
		case "female":
			this.sex = "여자";
			break;
		}
		this.age = age;
	}
	
	//3.메서드
	void printPerson() {
		System.out.println("==================================");
		System.out.println("이름: " + name);
		System.out.println("성별: " + sex);
		System.out.println("나이: " + age + "세");
	}
}

public class Exam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 성별(male/female), 나이를 입력하세요.");
		
		Person p1 = new Person(sc.next(),sc.next(),sc.nextInt());
		
		p1.printPerson();
		sc.close();
	}
}