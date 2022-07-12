package khie;

import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급(사장/전무/부장/차장/과장/대리/사원) 중 하나의 직급을 선택하세요: ");
		
		String position = sc.next();
		
		switch(position) {
		case "사장" :
			System.out.println("사장의 급여는 1,000만원입니다.");
			break;
		case "전무" :
			System.out.println("전무의 급여는 800만원입니다.");
			break;
		case "부장" :
			System.out.println("부장의 급여는 650만원입니다.");
			break;
		case "차장" :
			System.out.println("차장의 급여는 500만원입니다.");
			break;
		case "과장" :
			System.out.println("과장의 급여는 400만원입니다.");
			break;
		case "대리" :
			System.out.println("대리의 급여는 300만원입니다.");
			break;
		case "사원" :
			System.out.println("사원의 급여는 200만원입니다.");
			break;
		}
		
		System.out.println();
		
		//다중 if~else문을 이용하여 구현한 코드
		//if(position == "사장") { 문자열에는 '=='을 쓸 수 없어 } ==> equals 메서드를 사용
		if(position.equals("사장")) {
			System.out.println("사장의 급여는 1,000만원입니다.");
		}else if(position.equals("전무")) {
			System.out.println("전무의 급여는 800만원입니다.");
		}else if(position.equals("부장")) {
			System.out.println("부장의 급여는 650만원입니다.");
		}else if(position.equals("차장")) {
			System.out.println("차장의 급여는 500만원입니다.");
		}else if(position.equals("과장")) {
			System.out.println("과장의 급여는 400만원입니다.");
		}else if(position.equals("대리")) {
			System.out.println("대리의 급여는 300만원입니다.");
		}else if(position.equals("사원")) {
			System.out.println("사원의 급여는 200만원입니다.");
		}else {
			System.out.println("없는 직급 입니다.");
		}
		
		sc.close();
	}
}