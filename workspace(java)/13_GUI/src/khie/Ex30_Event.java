package khie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex30_Event extends JFrame implements ActionListener{
	
	JLabel result;

	public Ex30_Event() {
		
		setTitle("이벤트 예제");
		
		JPanel container = new JPanel();
		
		//1.컴포넌트를 만들어보자
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		
		JLabel label1 = new JLabel("당신의 성별은? : ");
		
		result = new JLabel(""); //결과가 출력된 컴포넌트
		
		//setForeground(): 글자색 지정
		result.setForeground(new Color(255, 0, 0));	//빨간색 글자
		
		//2.컴포넌트를 컨테이너에 올려야 한다.
		container.add(male); container.add(female);
		container.add(label1); container.add(result);
		
		//3.컨테이너를 프레임에 올려야한다.
		add(container);
		
		//중요한 작업
		//이벤트를 받을 컴포넌트에 이벤트 리스너를 등록하는 작업
		male.addActionListener(this);
		female.addActionListener(this);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex30_Event();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//getActionCommand() 메서드 ==> 이벤트를 처리한 컴포넌트(버튼)의 타이틀(문자열)을 가져오는 메서드
		String str = e.getActionCommand();
		result.setText(str);
	}

}
