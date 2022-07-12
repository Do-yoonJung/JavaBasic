package khie;

import java.awt.Frame;

/*
 * Frame을 만드는 방법 - 두번째 방법
 * - Frame이라는 클래스의 객체를 생성해서 사용
 */

public class Ex02_Frame {

	public static void main(String[] args) {

		Frame frame = new Frame();
		
		//프레임의 제목 설정
		frame.setTitle("두번째 예제");
		
		//프레임의 위치
		//frame.setLocation(100, 100);
		
		//프레임의 크기
		//frame.setSize(300, 300);
		
		//프레임의 위치 + 프레임의 크기
		frame.setBounds(100, 100, 300, 300);
		
		//프레임을 화면에 보여주기
		frame.setVisible(true);
	}

}
