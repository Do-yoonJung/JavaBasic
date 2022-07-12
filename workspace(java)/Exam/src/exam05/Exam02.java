package exam05;

import java.util.Scanner;

class Rectangle {
	int width;
	int length;
	
	Rectangle(int width, int length){
		this.width = width;
		this.length = length;
	}
	
	void print(){
		System.out.println("=====================================");
		System.out.println("사각형의 넓이: " + (width*length));
		System.out.println("사각형의 둘레: " + ((width+length) * 2));
	}
}


public class Exam02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("사각형의 가로, 세로를 입력하세요.");
		Rectangle r1 = new Rectangle(sc.nextInt(), sc.nextInt());
		
		r1.print();
		sc.close();
	}
}
