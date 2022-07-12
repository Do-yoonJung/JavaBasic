package exam05;

import java.util.Scanner;

class Temporary{
	String name;
	int time;
	int pay;
	
	Temporary(String name, int time, int pay){
		this.name = name;
		this.time = time;
		this.pay = pay;
	}
	
	void print() {
		int total = time * pay;
		int tax = (int)(total * 0.03);
		int real = total - tax;
		
		System.out.println("============================================");
		System.out.println("이름: " + name);
		System.out.printf("총급여: %,d원\n", total);
		System.out.printf("공제액: %,d원\n", tax);
		System.out.printf("실지급액: %,d원\n", real);
	}
}

public class Exam04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
		Temporary n1 = new Temporary(sc.next(), sc.nextInt(), sc.nextInt());
		n1.print();
		sc.close();
	}
}
