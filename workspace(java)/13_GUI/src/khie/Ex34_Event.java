package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex34_Event extends JFrame{

	public Ex34_Event() {
		setTitle("계산기 예제 - 3");
		
		JPanel container1 = new JPanel();	//상단1
		JPanel container2 = new JPanel();	//상단2
		JPanel container3 = new JPanel();	//하단
		
		//1.컴포넌트를 만들자
		//1-1.상단1
		JLabel label1 = new JLabel("수1: ");
		JTextField blank1 = new JTextField(5);
		
		JLabel label2 = new JLabel("수2: ");
		JTextField blank2 = new JTextField(5);
		
		//1-2 상단2
		JLabel label3 = new JLabel("연산자: ");
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
		
		//1-3 중앙 컴포넌트
		JTextArea area = new JTextArea(5, 20);
		JScrollPane scroll = new JScrollPane(
				area,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//1-4 하단
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		//2. 컴포넌트 컨테이너에 올리기
		//2-1 상단1
		container1.add(label1);
		container1.add(blank1);
		container1.add(label2);
		container1.add(blank2);
		
		//2-2 상단2
		container2.add(label3);
		container2.add(op1);
		container2.add(op2);
		container2.add(op3);
		container2.add(op4);
		container2.add(op5);
		
		//2-3 하단 컨테이너에 컴포넌트
		container3.add(result);
		container3.add(exit);
		container3.add(cancel);
		
		//새로운 컨테이너를 하나 더 만들자.
		JPanel group1 = new JPanel(new BorderLayout());
		
		//새로운 컨테이너에 기존의 컨테이너를 올리자
		group1.add(container2, BorderLayout.NORTH);
		group1.add(scroll, BorderLayout.CENTER);
		group1.add(container3, BorderLayout.SOUTH);
		
		add(container1,BorderLayout.NORTH);
		add(group1, BorderLayout.CENTER);
		
		setBounds(200,200,450,200);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//4.이벤트 처리
		//계산(result) 버튼을 클릭했을 때 이벤트 처
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int num1 = Integer.parseInt(blank1.getText());
				int num2 = Integer.parseInt(blank2.getText());
				
				String result ="";
				if(op1.isSelected()) {
					result = "결과: " + num1 + " + " + num2 + " = " +(num1+num2);
				}else if(op2.isSelected()) {
					result = "결과: " + num1 + " - " + num2 + " = " +(num1-num2);
				}else if(op3.isSelected()) {
					result = "결과: " + num1 + " * " + num2 + " = " +(num1*num2);
				}else if(op4.isSelected()) {
					result = "결과: " + num1 + " / " + num2 + " = " +(num1/num2);
				}else if(op5.isSelected()) {
					result = "결과: " + num1 + " % " + num2 + " = " +(num1%num2);
				}
				
				area.append(result + "\n");
				
				//입력받은 컴포넌트들은 모두 초기화
				blank1.setText(""); blank2.setText("");
				
				//라디오버튼 초기화
				opGroup.clearSelection();
				blank1.requestFocus();
			}
		});
		
		//종료 이벤트
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//취소 이벤트
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				blank1.setText(null);
				blank2.setText(null);
				area.setText(null);
				
				opGroup.clearSelection();
				blank1.requestFocus();
				
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new Ex34_Event();
	}

}
