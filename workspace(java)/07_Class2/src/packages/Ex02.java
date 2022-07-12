package packages;

import java.util.Scanner;
import model.MemberDTO;

/*
 * [문제] 회원 수를 키보드로 입력 받아서 회원 수만큼 객체 배열에 회원의 정보를 입력받아서 화면에 출력해보자.
 */

public class Ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//1.회원수를 키보드로 입력을 받아서 객체 배열에 회원수를 입력해보자.
		System.out.print("회원 수를 입력해주세요: ");
		MemberDTO[] dtos = new MemberDTO[sc.nextInt()];
		
		//2.반복문을 이용하여 회원 수만큼 회원 정보를 키보드로 입력을 받자.
		//인자생성자를 만들어서 해도 됨 (원래 내가 했던 방법)
		for(int i=0; i<dtos.length; i++) {
			dtos[i] = new MemberDTO();
			System.out.println((i+1) + "번째 회원의 아이디, 이름, 나이, 연락처, 주소를 입력하세요: ");
			
//			dtos[i].setId(sc.next());
//			dtos[i].setName(sc.next());
//			dtos[i].setAge(sc.nextInt());
//			dtos[i].setPhone(sc.next());
//			dtos[i].setAddress(sc.next());
			dtos[i] = new MemberDTO(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next());
		}
		
		//3.반복문을 이용하여 객체 배역에 저장된 데이터들을 화면에 출력해보자.
		for(int i=0; i<dtos.length; i++) {
			System.out.println("아이디: " + dtos[i].getId());
			System.out.println("이름: " + dtos[i].getName());
			System.out.println("나이: " + dtos[i].getAge());
			System.out.println("연락처: " + dtos[i].getPhone());
			System.out.println("주소: " + dtos[i].getAddress());
			System.out.println("===========================");
		}
		
		sc.close();
	}

}
