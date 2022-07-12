package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex33_Event extends JFrame {
	
	public Ex33_Event() {
		
		setTitle("간단한 계산기 예제");
		
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

		//4.이벤트 처리
		//4-1. 계산(result) 버튼을 클릭했을 때 이벤트 처리
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(su1.getText());
				int num2 = Integer.parseInt(su2.getText());
				String operator = op.getText();
				
				String result = "";
	
				switch(operator) {
				case "+" :
					result = "결과: " + num1 + " + " + num2 + " = " + (num1+num2);
					break;
				case "-" :
					result = "결과: " + num1 + " - " + num2 + " = " + (num1-num2);
					break;
				case "*" :
					result = "결과: " + num1 + " * " + num2 + " = " + (num1*num2);
					break;
				case "/" :
					result = "결과: " + num1 + " / " + num2 + " = " + (num1/num2);
					break;
				case "%" :
					result = "결과: " + num1 + " % " + num2 + " = " + (num1%num2);
					break;
				} //switch~case문 end
				
				jta.append(result + "\n");
				
				su1.setText(null); su2.setText(null);
				op.setText(null);
				
				su1.requestFocus(); // 깜빡깜빡
				
			}
		});
		
		//4-2.종료 버튼을 클릭했을 때 이벤트 처리
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		
		//4-3.취소 버튼
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//전체 컴포넌트의 값을 초기화 하는 작업
				su1.setText(null);
				su2.setText(null);
				op.setText(null);
				jta.setText(null);
				
				su1.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		new Ex33_Event();
	}

}
