package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex35_Event extends JFrame {

	public Ex35_Event() {
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
		
		//4.이벤트 처리
		//계산 버튼 클릭시 이벤트 처리
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String name1 = name.getText();
				int korean = Integer.parseInt(kor.getText());
				int english = Integer.parseInt(eng.getText());
				int math = Integer.parseInt(mat.getText());
				
				//총점
				int total = korean + english + math;
				//평균
				double avg = total/3.0;
				//학점
				String grade = "";
				
				if(avg>=90) {
					grade = "A학점";
				}else if (avg>=80) {
					grade = "B학점";
				}else if (avg>=70) {
					grade = "C학점";
				}else if (avg>=60) {
					grade = "D학점";
				}else {
					grade = "F학점";
				}
				
				jta.append("*** " + name1 + "님 성적결과***\n");
				jta.append("이름: " + name1 + "\n");
				jta.append("국어점수: " + korean + "점\n");
				jta.append("영어점수: " + english + "점\n");
				jta.append("수학점수: " + math + "점\n");
				jta.append("총점: " + total + "점\n");
				jta.append("평균: " + String.format("%.2f점", avg) + "\n");
				jta.append("학점: " + grade + "\n");
				
				//컴포넌트 초기화
				name.setText(null);
				kor.setText(null);
				eng.setText(null);
				mat.setText(null);
				
				name.requestFocus();
				
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

				name.setText(null);
				kor.setText(null);
				eng.setText(null);
				mat.setText(null);
				jta.setText(null);
				name.requestFocus();
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Ex35_Event();
	}
}
