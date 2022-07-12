package khie;

import java.awt.BorderLayout;

import javax.swing.*;

public class Ex22_Layout02 extends JFrame {

	public Ex22_Layout02() {
		
		setTitle("계산기2");
		
		//1. 컨테이너 만들기
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		//2. 컴포넌트 만들기
		//상단
		JLabel label1 = new JLabel("수1: ");
		JTextField blank1 = new JTextField(5);
		JLabel label2 = new JLabel("수2: ");
		JTextField blank2 = new JTextField(5);
		JLabel label3 = new JLabel("연산자: ");
		
		//연산자 라디오버튼 컴포넌트
		JRadioButton op1 = new JRadioButton("+");
		JRadioButton op2 = new JRadioButton("-");
		JRadioButton op3 = new JRadioButton("*");
		JRadioButton op4 = new JRadioButton("/");
		JRadioButton op5 = new JRadioButton("%");
		
		//연산자 라디오버튼 그룹
		ButtonGroup opGroup = new ButtonGroup();
		opGroup.add(op1);
		opGroup.add(op2);
		opGroup.add(op3);
		opGroup.add(op4);
		opGroup.add(op5);
		
		//중단
		JTextArea area = new JTextArea(5, 20);
		JScrollPane scroll = new JScrollPane(
				area,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//하단
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		//3. 컴포넌트 컨테이너에 올리기
		
		container1.add(label1);
		container1.add(blank1);
		container1.add(label2);
		container1.add(blank2);
		container1.add(label3);
		container1.add(op1);
		container1.add(op2);
		container1.add(op3);
		container1.add(op4);
		container1.add(op5);
		
		container2.add(result);
		container2.add(exit);
		container2.add(cancel);
		
		//4. 컨테이너 배치, 프레임에 올리기
		add(container1, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(container2, BorderLayout.SOUTH);
		
		setBounds(200,200,450,200);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex22_Layout02();
	}

}
