package khie;

import javax.swing.*;

public class Ex17_ETC extends JFrame{

	public Ex17_ETC() {
		
		setTitle("기타 예제");
		
		JPanel container = new JPanel();
		
		//1. 컴포넌트를 만들어보자.
		JLabel jl1 = new JLabel("아이디: ");
		JTextField id = new JTextField(10);
		
		JLabel jl2 = new JLabel("비밀번호: ");
		JPasswordField pwd = new JPasswordField(10);
		
		JLabel jl3 = new JLabel("하고 싶은 말: ");
		JTextArea jta = new JTextArea(5, 20);
		
		JScrollPane jsp = new JScrollPane(
				jta,		//스크롤바라 보여질 컴포넌트
				
				//수직으로 스크롤바가 필요한지 여부 확인
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				
				//수평으로 스크롤바가 필요한지 여부 확인
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		//JtextArea 컴포넌트에서 자동으로 줄바꿈 기능을 제공해주는 메서드
		jta.setLineWrap(true);
		
		//2.컴포넌트를 컨테이너에 옮겨야한다.
		container.add(jl1);
		container.add(id);
		container.add(jl2);
		container.add(pwd);
		container.add(jl3);
		container.add(jsp);
		
		//3.컨테이너를 프레임에 올려야한다.
		add(container);
		
		setBounds(200,200,250,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
	}
	
	public static void main(String[] args) {

		new Ex17_ETC();
		
	}

}
