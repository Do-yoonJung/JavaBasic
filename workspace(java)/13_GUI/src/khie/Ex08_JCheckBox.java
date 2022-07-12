package khie;

import javax.swing.*;

public class Ex08_JCheckBox extends JFrame{
	
	public Ex08_JCheckBox() {

		setTitle("과일 체크박스 예제");
		
		//컨테이너 만들기
		JPanel container = new JPanel();
		
		//1-1. 이미지 아이콘을 만들어보자.
		ImageIcon kiwi = new ImageIcon("images/kiwi.jpg");
		ImageIcon mango = new ImageIcon("images/mango.jpg");
		ImageIcon apple = new ImageIcon("images/apple.jpg");
		
		//1-2. 컴포넌트를 만들어보자.
		JCheckBoxMenuItem jcb1 = new JCheckBoxMenuItem("키위", kiwi);
		JCheckBoxMenuItem jcb2 = new JCheckBoxMenuItem("망고", mango);
		JCheckBoxMenuItem jcb3 = new JCheckBoxMenuItem("사과", apple);
		
		//2. 컴포넌트를 컨테이너에 올려야 한다.
		container.add(jcb1);
		container.add(jcb2);
		container.add(jcb3);
		
		//3. 컨테이너를 프레임에 올려야한다.
		add(container);
		setBounds(200, 200, 300, 600);
		
		//프레임의 크기를 고정시키는 메서드
		setResizable(false);
		
		//프레임의 x버튼 클릭 시 종료시키는 메서드
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex08_JCheckBox();
	}

}
