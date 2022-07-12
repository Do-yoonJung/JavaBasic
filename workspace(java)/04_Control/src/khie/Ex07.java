package khie;

import javax.swing.JOptionPane;

/*
 * 키보드로부터 입력받은 정수값이 5의 배수이면 "이 정수는 5의 배수입니다."라고 출력, 
 * 그렇지 않으면 "이 정수는 5의 배수가 아닙니다." 라고 출력
 * 단, 입력받은 정수가 음수이면 "음수 값이 입력되었습니다."라고 출력
 */

public class Ex07 {

	public static void main(String[] args) {
		
		//1. 키보드로부터 정수를 입력받기
		int num = Integer.parseInt(JOptionPane.showInputDialog("정수 하나를 입력해주세요"));
		
		//2. 입력받은 정수가 양수인지 음수인지 먼저 판별
		if(num > 0) {
			//입력받은 정수는 양수
			if((num % 5) == 0) {
				System.out.println("입력받은 " + num + " 은 5의 배수입니다.");
			}else {
				System.out.println("입력받은 " + num + " 은 5의 배수가 아닙니다.");
			}
		}else {
			//입력받은 정수는 음수
			System.out.println("음수 값이 입력되었습니다.");
		}
	}
}