package teach_exam06_1;

import java.util.Scanner;

public class Exam_08 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String pt = "";		//고용형태 문자열이 저장될 변수
		
		System.out.println("고용형태 - 정규직<P>, 임시직<T>를 입력하세요.");
		
		pt = sc.next();
		
		if(pt.equalsIgnoreCase("P")) {
			pt = "정규직";
			System.out.println("이름, 기본급, 보너스를 입력하세요.....");
			Permanent1 permanent1 = new Permanent1(sc.next(), sc.nextInt(), sc.nextInt());
			
			System.out.println("::::::::::::::::::::::::::::::::::::::");
			
			System.out.println("고용형태: " + pt);
			System.out.println("이름: " + permanent1.getName());
			System.out.printf("급여: %,d원\n", permanent1.getPay());
			}else if(pt.equalsIgnoreCase("T")) {
				pt = "임시직";
				System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.....");
				Temporary1 temporary1 = new Temporary1(sc.next(), sc.nextInt(), sc.nextInt());
				
				System.out.println("::::::::::::::::::::::::::::::::::::::");
				
				System.out.println("고용형태: " + pt);
				System.out.println("이름: " + temporary1.getName());
				System.out.printf("급여: %,d원\n", temporary1.getPay());
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		
		sc.close();
	}
}
