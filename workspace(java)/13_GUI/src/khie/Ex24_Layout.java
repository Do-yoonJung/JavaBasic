package khie;

import java.awt.BorderLayout;

import javax.swing.*;

public class Ex24_Layout extends JFrame {

	public Ex24_Layout() {
		setTitle("성적 처리");
		
		//컨테이너 3개
		JPanel container1 = new JPanel(); //North-1 컨테이너
		JPanel container2 = new JPanel(); //North-2 컨테이너
		JPanel container3 = new JPanel(); //South 컨테이너
		
		//1.컴포넌트
		//1-1-1. 상단(North-1 컨테이너)
		JLabel jl1 = new JLabel("이름: ");
		JTextField name = new JTextField(10);
		
		//1-1-2. 상단(North-2 컨테이너)
		JLabel jl2 = new JLabel("국어: ");
		JTextField kor = new JTextField(5);
		JLabel jl3 = new JLabel("영어: ");
		JTextField eng = new JTextField(5);
		JLabel jl4 = new JLabel("수학: ");
		JTextField mat = new JTextField(5);
		
		//1-2. 중앙 컴포넌트
		JTextArea jta = new JTextArea(5, 20);
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jta.setLineWrap(true); 	//자동 줄바꿈
		
		//1-3. 하단 컴포넌트
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		//2. 컴포넌트를 컨테이너에 올리기
		//2-1. north-1
		container1.add(jl1);
		container1.add(name);
		
		container2.add(jl2);
		container2.add(kor);
		container2.add(jl3);
		container2.add(eng);
		container2.add(jl4);
		container2.add(mat);
		
		container3.add(result);
		container3.add(exit);
		container3.add(cancel);
		
		//새로운 컨테이너
		JPanel group = new JPanel(new BorderLayout());
		
		group.add(container2, BorderLayout.NORTH);
		group.add(jsp, BorderLayout.CENTER);
		group.add(container3, BorderLayout.SOUTH);
		
		//컨테이너를 프레임에 올리기
		add(container1, BorderLayout.NORTH);
		add(group, BorderLayout.CENTER);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex24_Layout();
	}
}
