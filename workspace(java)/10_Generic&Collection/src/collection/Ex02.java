package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02 {

	public static void main(String[] args) {

		//다형성을 이용하여 ArrayList 객체 생성
		List<String> list = new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		//Iterator: 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어있는 요소들을 읽어오는 방법을 표준화 해놓은 객체
		Iterator<String> it =  list.iterator();
		
		//hasNext(): 읽어올 요소가 있는지 확인하는 메서드 - boolean형으로 반환
		while(it.hasNext()) {
			//next(): 요소를 가져오는 메서드
			System.out.println(it.next());
		}
	}

}
