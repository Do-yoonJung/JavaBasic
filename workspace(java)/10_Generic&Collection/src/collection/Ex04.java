package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.MemberDTO;

//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
public class Ex04 {

	public static void main(String[] args) {

		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원수를 입력하세요: ");
		
		int memberCount = sc.nextInt();
		
		//1. 키보드로 회원의 수만큼 회원 정보를 입력받아서
		//   list(ArrayList)에 저장해보자
		for(int i=0; i<memberCount; i++) {
			
			System.out.println((i+1) + "번째 회원의 " + "아이디, 이름 나이 연락처, 주소를 입력하세요. ");
			
			MemberDTO dto = new MemberDTO(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next());

			list.add(dto);
			
			System.out.println("============================================");
			
		}
		
		//System.out.println("list[0]: " + list.get(0));
		
		//2. list에 들어있는 데이터들을 화면에 출력해보자.
		for(int i=0; i<list.size(); i++) {
			MemberDTO dto = list.get(i);
			
			System.out.print(dto.getId()+"\t" + dto.getName() + "\t" 
			+ dto.getAge()+ "\t" + dto.getPhone() + "\t" +dto.getAddress());
			//System.out.println("dto: " + dto);
		}
		
		sc.close();
	}

}
