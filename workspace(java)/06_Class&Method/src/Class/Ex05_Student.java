package Class;

import java.util.Scanner;

public class Ex05_Student {

	public static void main(String[] args) {
		
		/*
		 * int num = Integer.parseInt(JOptionPane.showInputDialog("학번 입력"));
		 * String name = JOptionPane.showInputDialog("이름 입력"));
		 * ...
		 * 
		 * Student student = new Student(num, name ...);
		 * 
		 */
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학번, 이름, 학과, 주소를 입력하세요.");
		
		Student student = new Student(sc.nextInt(), sc.next(), sc.next(), sc.next());
		
		student.display();
		
		sc.close();
		
	}
}
