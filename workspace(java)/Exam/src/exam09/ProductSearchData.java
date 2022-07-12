package exam09;

import java.util.HashMap;
import java.util.Map;

public class ProductSearchData {

	//상품명과 상품정보가 저장될 Map 자료구조 선언
	
	Map<String, String> map;
	
	ProductSearchData(){
		map = new HashMap<String, String>();
		
		//데이터들을 map에 저장해보자
		map.put("세탁기", "드럼 세탁기 최신형");
		map.put("냉장고", "지펠 냉장고 최신형");
		map.put("TV", "HDTV 150인치 최신 모델");
	}//기본 생성자
	
	//상품명을 매개변수로 받아서 해당 상품명이 Map의 key에 있는지 확인하여 존재하면 상품정보를 반환하는 메서드
	String search(String productName) {
		
		String productInfo = null;	//반환될 상품정보가 저장될 변수
		
		if(map.containsKey(productName)){
			productInfo = map.get(productName);
		}
		
		return productInfo;
	}
	
}
