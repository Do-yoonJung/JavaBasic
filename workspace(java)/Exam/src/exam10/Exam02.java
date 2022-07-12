package exam10;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam02 extends JFrame {

	public Exam02() {
		setTitle("성적 처리");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		//1. 컴포넌트 만들기
		//상단-1
		JLabel label1 = new JLabel("이름: ");
		JTextField name = new JTextField(20);
		//상단2
		JLabel label2 = new JLabel("국어:");
		JTextField kor = new JTextField(5);
		JLabel label3 = new JLabel("영어: ");
		JTextField eng = new JTextField(5);
		JLabel label4 = new JLabel("수학: ");
		JTextField math = new JTextField(5);
		
		//하단
		JTextArea blank = new JTextArea(5,20);
		JScrollPane scroll = new JScrollPane(
				blank,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		//2. 컨테이너에 컴포넌트 올리고 배치
		container1.add(label1);
		container1.add(name);
		
		container2.add(label2);
		container2.add(kor);
		container2.add(label3);
		container2.add(eng);
		container2.add(label4);
		container2.add(math);
		
		container3.add(result);
		container3.add(exit);
		container3.add(cancel);

		//새로운 컨테이너 및 배치
		JPanel group1 = new JPanel(new BorderLayout());
		group1.add(container2, BorderLayout.NORTH);
		group1.add(scroll, BorderLayout.CENTER);
		group1.add(container3, BorderLayout.SOUTH);
		
		add(container1, BorderLayout.NORTH);
		add(group1, BorderLayout.CENTER);
		
		setBounds(200,200,500,500);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam02();
	}
	
}
