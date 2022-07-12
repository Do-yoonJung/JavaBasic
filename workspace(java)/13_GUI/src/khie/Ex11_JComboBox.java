package khie;

import javax.swing.*;

public class Ex11_JComboBox extends JFrame{

	public Ex11_JComboBox() {
		
		setTitle("JComboFrame 예제");
		
		//컨테이너를 만들자
		JPanel container = new JPanel();
		
		//1.컴포넌트를 만들어보자.
		String[] job = {"회사원", "공무원", "학생", "주부", "무직", "기타"};
		JComboBox<String> jcb = new JComboBox<String>(job);
		
		//JComboBox에서 초기값을 설정하는 방법
		//jcb.setSelectedIndex(2);
		jcb.setSelectedItem("공무원");
		
		//2.컴포넌트를 컨테이너에 올려야한다.
		container.add(jcb);
		
		//3.컨테이너를 프레임에 올리기
		add(container);
		
		setBounds(200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Ex11_JComboBox();
	}

}
