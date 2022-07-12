package khie;

import javax.swing.*;

public class Ex07_JCheckBox extends JFrame{
	
	public Ex07_JCheckBox() {

		setTitle("JCheckBox 예제");
		
		//컨테이너를 만들자
		JPanel container = new JPanel();
		
		//1.컴포넌트를 만들어보자.
		JCheckBox jcb1 = new JCheckBox("게임");
		JCheckBox jcb2 = new JCheckBox("여행", true);
		JCheckBox jcb3 = new JCheckBox("영화감상");
		JCheckBox jcb4 = new JCheckBox("운동");
		JCheckBox jcb5 = new JCheckBox("잠자기");
	
		//2.컴포넌트를 컨테이너에 올려야한다.
		container.add(jcb1);
		container.add(jcb2);
		container.add(jcb3);
		container.add(jcb4);
		container.add(jcb5);
		
		//3.컨테이너를 프레임에 올려야한다.
		add(container);
		setBounds(100, 100, 400, 300);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {

		new Ex07_JCheckBox();
	}

}
