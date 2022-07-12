package exam07_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도형을 선택하세요.(1.원형, 2.사각형)");
		System.out.print("도형 선택: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.print("반지름 입력: ");
			Circle c1 = new Circle(sc.nextInt());
			System.out.println("==================================");
			System.out.printf("원의 면적: ", c1.findArea());
			break;
		case 2:
			System.out.println("가로: ");
			System.out.println("세로: ");
			Rectangle r1 = new Rectangle(sc.nextInt(), sc.nextInt());
			System.out.println("==================================");
			System.out.printf("사각형의 면적: ", r1.findArea());
			break;
		default:
			System.out.println("없는 도형입니다.");
			break;
		}
		
		sc.close();
	}
}
