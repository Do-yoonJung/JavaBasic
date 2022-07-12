package exam08;

public class ProductSearchData {
	
	String[][] proTable;			//배열 선언
	
	public ProductSearchData() {
		
		proTable = new String[3][2];
		
		//[0]인덱스에는 상품명을 저장, [1]인덱스에는 상품정보를 저장.
		proTable[0][0] = "세탁기";
		proTable[0][1] = "드럼 세탁기 최신형";
		
		proTable[1][0] = "냉장고";
		proTable[1][1] = "지펠 냉장고 최신형";
		
		proTable[2][0] = "TV";
		proTable[2][1] = "HDTV 150인치 최신 모델";
	}	//기본 생성자
	
	//상품명을 매개변수로 넘겨 받아서 해당 상품에 대한 상품정보를 반환해주는 메서드
	String search(String productName) {
		
		String productInfo = null; 	//상품정보가 저장될 변수
		
		for(int i=0; i<proTable.length; i++) {
			if(productName.equals(proTable[i][0])) {
				productInfo = proTable[i][1];
			}
		}
		
		return productInfo;
	}
}
