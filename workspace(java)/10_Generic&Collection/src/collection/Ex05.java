package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.StudentDTO;

/*
 * [문제] Ex04 클래스처럼 키보드로 학생 수를 입력 받고, 입력 받은 학생 수 만큼의 정보를 키보드를 입력 받아서
 *       ArrayList에 정보를 저장 후 화면에 출력해보시오.
 *       (단, 학생의 정보는 학번, 이름, 학과, 연락처, 주소)
 */

public class Ex05 {

	public static void main(String[] args) {

		//1. 키보드로 학생 수 만큼의 학생 정보를 입력받아서 ArrayList에 저장을 하자
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("전체 학생 수를 입력해주세요: ");
		int memberCount = sc.nextInt();
		
		for(int i=0; i<memberCount; i++) {
			System.out.println((i+1) + "번째 학생의 학번, 이름, 학과, 연락처, 주소를 입력하세요.");
			StudentDTO dto = new StudentDTO(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			
			list.add(dto);
			
			System.out.println("dto[" + i + "]" + dto);
			System.out.println("===================================");
		}
		
		System.out.println("학번\t이름\t학과\t연락처\t주소");
		
		for(int i=0; i<list.size(); i++) {
			
			StudentDTO dto = list.get(i);
			System.out.println(dto.getNum() + "\t" + dto.getName() + "\t" + dto.getMajor()
			 				+ "\t" + dto.getPhone() + "\t" + dto.getAddress());
		}
		
		sc.close();
	}

}
