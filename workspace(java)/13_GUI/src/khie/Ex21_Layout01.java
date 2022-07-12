package khie;

import java.awt.BorderLayout;

//간단하게 계산기 화면을 구성

import javax.swing.*;
import javax.swing.border.Border;

public class Ex21_Layout01 extends JFrame {

	public Ex21_Layout01() {
		
		setTitle("간단한 계산기");
		
		//컨테이너를 3개 만든다.
		JPanel container1 = new JPanel(); //상단
		JPanel container2 = new JPanel(); //중단
		JPanel container3 = new JPanel(); //하단
		
		//1. 컴포넌트 만들기
		//1-1. 상단
		JLabel jl1 = new JLabel("수1: ");
		JTextField su1 = new JTextField(5);
		JLabel jl2 = new JLabel("수2: ");
		JTextField su2 = new JTextField(5);
		JLabel jl3 = new JLabel("연산자: ");
		JTextField op = new JTextField(5);
		
		//1-2. 중단
		JTextArea jta = new JTextArea(5, 20);
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jta.setLineWrap(true);	//자동 줄바꿈 기능 설정
		
		//1-3. 하단
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		//2. 컴포넌트들을 컨테이너에 추가
		//2-1. 상단
		container1.add(jl1);
		container1.add(su1);
		container1.add(jl2);
		container1.add(su2);
		container1.add(jl3);
		container1.add(op);
		
		//2-2. 중단
		container2.add(jsp);

		//2-3. 하단
		container3.add(result);
		container3.add(exit);
		container3.add(cancel);
		
		//3.컨테이너를 프레임에 올려준다.
		//프레임에 3개의 컨테이너를 올려야함. 배치를 해서 올려
		add(container1, BorderLayout.NORTH);
		add(container2, BorderLayout.CENTER);
		add(container3, BorderLayout.SOUTH);
		
		setBounds(200, 200, 350, 350);
		
		//pack(): JFrame에 올라온 컴포넌트(내용물)를 알맞게 프레임의 크기를 조절해주는 메서드
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex21_Layout01();
	}

}
