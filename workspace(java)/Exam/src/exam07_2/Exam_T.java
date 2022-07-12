package exam07_2;

import java.util.Scanner;

public class Exam_T {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("도형을 선택하세요.(1.원형, 2.사각형)");
		
		System.out.print("도형 선택: ");
		
		int menu = sc.nextInt();
		
		if(menu == 1) {	//원형을 선택한 경우
			System.out.print("반지름 입력: ");
			
			CircleT circle = new CircleT(sc.nextInt());
			
			System.out.println("================================");
			
			System.out.printf("원의 면적: %.1f", circle.findArea());
			
		}else if(menu == 2) { //사각형을 선택한 경우
			
			System.out.print("가로 입력: ");
			int width = sc.nextInt();
			
			System.out.print("세로 입력: ");
			int height = sc.nextInt();
			
			RectangleT rectangle = new RectangleT(width, height);
			
			System.out.println("================================");
			
			System.out.printf("사각형의 면적: %.1f", rectangle.findArea());
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		sc.close();
	}

}
