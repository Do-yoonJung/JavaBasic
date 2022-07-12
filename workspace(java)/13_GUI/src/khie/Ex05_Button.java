package khie;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class Ex05_Button extends Frame{

	public Ex05_Button() {

		setTitle("Button 예제");
		
		//컨테이너 만들기
		Panel panel = new Panel();
		
		//1.컴포넌트 만들기
		Button button = new Button("Button1");
		
		//2.컴포넌트를 컨테이너에 올리기
		panel.add(button);
		
		//3.컨테이너를 프레임에 올리기
		add(panel);
		
		setBounds(100, 100, 300, 300);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new Ex05_Button();		
	}

}
