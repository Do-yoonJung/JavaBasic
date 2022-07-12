package khie;

import javax.swing.*;

public class Ex09_JRadioButton extends JFrame{

	public Ex09_JRadioButton() {

		setTitle("JRadioButton 예제");
		
		JPanel container = new JPanel();
	
		//1.컴포넌트를 만들자
		JRadioButton jrb1 = new JRadioButton("게임");
		JRadioButton jrb2 = new JRadioButton("여행", true);
		JRadioButton jrb3 = new JRadioButton("운동");
		JRadioButton jrb4 = new JRadioButton("잠자기");
		
		//라디오버튼은 반드시 ButtonGroup에 올려져야한다. 아니면 중복선택됨
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		//2.컴포넌트를 컨테이너에 올리기
		container.add(jrb1);
		container.add(jrb2);
		container.add(jrb3);
		container.add(jrb4);
		
		//3.컨테이너를 프레임에 올리기
		add(container);
		
		setBounds(200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new Ex09_JRadioButton();
		
	}

}
