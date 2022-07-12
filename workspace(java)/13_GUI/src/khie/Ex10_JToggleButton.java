package khie;

import javax.swing.*;

public class Ex10_JToggleButton extends JFrame{

	public Ex10_JToggleButton() {

		setTitle("JToggleButton 예제");
		
		//컨테이너 만들기
		JPanel container = new JPanel();
		
		//1.컴포넌트 만들기
		JToggleButton jtb1 = new JToggleButton("토글버튼1");
		JToggleButton jtb2 = new JToggleButton("토글버튼2");
		JToggleButton jtb3 = new JToggleButton("토글버튼3");
		
		//2.컴포넌트를 컨테이너에 옮기기
		container.add(jtb1);
		container.add(jtb2);
		container.add(jtb3);
		
		//3.컨테이너를 프레임에 올리기
		add(container);
		
		setBounds(200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new Ex10_JToggleButton();
	}

}
