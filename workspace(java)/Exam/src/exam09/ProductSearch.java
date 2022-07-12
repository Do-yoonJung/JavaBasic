package exam09;

import javax.swing.JOptionPane;

public class ProductSearch {

	public static void main(String[] args) {
		
		String productName = JOptionPane.showInputDialog("검색할 상품명을 입력하세요.");
		
		ProductSearchData ps = new ProductSearchData();
		
		String productInfo = ps.search(productName);
		
		try {
			productInfo.length();
			JOptionPane.showMessageDialog(null, productInfo);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "해당 상품이 없습니다.");
		}
		
	}
}
