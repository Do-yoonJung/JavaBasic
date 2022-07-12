package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 3. Map 계열의 컬렉션 프레임워크 특징
 *    - key, value를 한 쌍으로 데이터를 저장하고, 검색하는 기능을 제공함
 *    - key는 중복 불가, value는 중복 가능
 *    - Map 인터페이스의 자식클래스로 구현
 *      ==> HashMap(O), HashTable(O), Properties(가끔), TreeMap(X)
 */

public class Ex09 {

	public static void main(String[] args) {

		//Map 인터페이스의 자식클래스를 이용하여 객체 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//1. put(): map에 데이터를 저장하는 메서드.
		//   ==> 이름을 키(key)로 저장, 점수를 값(value)으로 저장
		map.put("홍길동", 95);
		map.put("유관순", 90);
		map.put("세종대왕", 100);
		map.put("김유신", 88);
		map.put("김연아", 89);
		
		//2. get(key): map에 저장된 데이터를 가져오는(검색) 메서드.
		//   ==> get(key) 메서드를 호출을 하면 키에 해당하는 value 값을 반환.
		System.out.println("세종대왕 점수: " + map.get("세종대왕") + "점");
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요: ");
		
		String searchName = sc.next();
		
		//containsKey(): 인자로 넘어온 키가 map에 있는지 여부를 확인하는 메서드
		if(map.containsKey(searchName)) {
			System.out.println(searchName + "님의 점수: " + map.get(searchName) + "점");
		}else {
			System.out.println("검색한 이름이 없습니다.");
		}
		
		System.out.println();
		
		//keySet(): map의 전체 데이터를 출력하는 메서드
		for(String k : map.keySet()) {
			System.out.println(k + "님의 점수: " + map.get(k) + "점");
		}
		
		sc.close();
		
	}

}
