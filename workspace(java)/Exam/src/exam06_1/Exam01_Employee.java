package exam06_1;

import java.util.Scanner;

public class Exam01_Employee {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("고용형태-정규직<P>, 임시직<T>를 입력하세요.");
		String type = sc.next();
		
		if(type.equalsIgnoreCase("p")) {
			System.out.println("이름, 기본급, 보너스를 입력하세요.");
			type = "정규직";
			Permanent permanent = new Permanent(sc.next(), sc.nextInt(), sc.nextInt());
			
			System.out.println("=====================================");
			System.out.println("고용형태: " + type);
			System.out.println("이름: " + permanent.getName());
			System.out.printf("급여: %,d원\n", permanent.getPay());
			
		}else if(type.equalsIgnoreCase("t")) {
			System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
			type = "임시직";
			Temporary temporary = new Temporary(sc.next(), sc.nextInt(), sc.nextInt());
			
			System.out.println("=====================================");
			System.out.println("고용형태: " + type);
			System.out.println("이름: " + temporary.getName());
			System.out.printf("급여: %,d원\n", temporary.getPay());
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		sc.close();
	}
	
}
