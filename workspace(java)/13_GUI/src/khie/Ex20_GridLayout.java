package khie;

import java.awt.GridLayout;

/*
 * 3. GridLayout 배치관리자
 *    - 격자 모양의 배치관리자
 *    - 행과 열로 화면이 구성이 됨
 *    - 기준: 무조건 행이 기준이 됨
 */

import javax.swing.*;

public class Ex20_GridLayout extends JFrame{
	
	public Ex20_GridLayout() {
		
		setTitle("GridLayout 배치관리자");
		JPanel container = new JPanel();
		
		//1.컴포넌트를 만들어보자
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton button10 = new JButton("*");
		JButton button11 = new JButton("0");
		JButton button12 = new JButton("#");
		
		//1-1.컨테이너에 올리기 전에 배치관리자를 지정해야 한다.
		//	  형식)
		//			new GridLayout(행 수, 열 수)
		//			new GridLayout(행 수, 열 수, 수평간격, 수직간격)
		//				- 수평간격: 좌우 컴포넌트 사이의 간격(픽셀단위) - 기본값은 0
		//				- 수직간격: 상하 컴포넌트 사이의 간격(픽셀단위) - 기본값은 0
		container.setLayout(new GridLayout(4, 3, 10, 10));
		
		//2.컴포넌트를 컨테이너에 올린다.
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
		container.add(button5);
		container.add(button6);
		container.add(button7);
		container.add(button8);
		container.add(button9);
		container.add(button10);
		container.add(button11);
		container.add(button12);
		
		//3.컨테이너를 프레임에 올려야 한다.
		add(container);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {

		new Ex20_GridLayout();
	}

}
