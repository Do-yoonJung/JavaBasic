package Class;

import java.util.Scanner;

public class Ex06_Member {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Member member = new Member();
		
		System.out.println("당신의 이름, 나이, 연락처, 직업을 입력하세요.");
		
		Member member = new Member(sc.next(), sc.nextInt(), sc.next(), sc.next());
		
		member.getMemberInfo();
		
		sc.close();
	}

}
