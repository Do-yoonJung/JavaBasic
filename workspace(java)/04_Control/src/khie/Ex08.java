package khie;

import javax.swing.JOptionPane;

//키보드로 두 수를 입력받아서 그 중에 큰 정수를 화면에 출려해보세요.

public class Ex08 {

	public static void main(String[] args) {
		
		//1. 키보드로 두 수 입력받기
		int num = Integer.parseInt(JOptionPane.showInputDialog("첫번째 정수 입력"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("두번째 정수 입력"));
		
		//2. 최대값 구하기
		int max, min;
		
		if(num > num2) {
			max = num;
			min = num2;
		}else {
			max = num2;
			min = num;
		}
		
		System.out.println("최대값은 " + max + " 입니다.");
		System.out.println("최소값은 " + min + " 입니다.");
	}
}