package exam11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Exam02 extends JFrame{
	public Exam02() {
		
		setTitle("성적 처리");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		JLabel label1 = new JLabel("이름: ");
		JTextField name = new JTextField(5);
		
		JLabel label2 = new JLabel("국어: ");
		JTextField kor = new JTextField(5);
		JLabel label3 = new JLabel("영어: ");
		JTextField eng = new JTextField(5);
		JLabel label4 = new JLabel("수학: ");
		JTextField mat = new JTextField(5);
		
		JTextArea jta = new JTextArea(10,20);
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		container1.add(label1);
		container1.add(name);
		
		container2.add(label2);
		container2.add(kor);
		container2.add(label3);
		container2.add(eng);
		container2.add(label4);
		container2.add(mat);
		
		container3.add(result);
		container3.add(exit);
		container3.add(cancel);
		
		JPanel group = new JPanel(new BorderLayout());
		group.add(container2, BorderLayout.NORTH);
		group.add(jsp, BorderLayout.CENTER);
		group.add(container3, BorderLayout.SOUTH);
		
		add(container1, BorderLayout.NORTH);
		add(group, BorderLayout.CENTER);
		
		setBounds(200,200,500,500);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//계산 이벤트
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String n = name.getText();
				int korean = Integer.parseInt(kor.getText());
				int english = Integer.parseInt(eng.getText());
				int math = Integer.parseInt(mat.getText());
				int total = korean + english + math;
				double average = total/3.0;
				
				System.out.println("***" + n + "님 성적결과***");
				System.out.println("이름:" + n);
				System.out.println("국어점수:" + korean + "점");
				System.out.println("영어점수:" + english + "점");
				System.out.println("수학점수:" + math + "점");
				System.out.println("총점:" + total + "점");
				System.out.printf("평균:%.2f점\n", average);
				
				if(average>=90) {
					System.out.println("학점:A학점");
				}else if(average>=80) {
					System.out.println("학점:B학점");
				}else if(average>=70) {
					System.out.println("학점:C학점");
				}else if(average>=60) {
					System.out.println("학점:D학점");
				}else {
					System.out.println("학점:F학점");
				}
				
				jta.append(n);
			}
		});
		
		//종료
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		
		//취소
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				kor.setText(null);
				eng.setText(null);
				mat.setText(null);
				jta.setText(null);
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Exam02();
	}
}
