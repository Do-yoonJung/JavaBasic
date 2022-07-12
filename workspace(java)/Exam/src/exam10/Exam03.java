package exam10;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam03 extends JFrame {
	
	Exam03(){
		setTitle("커피 자판기");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		JLabel title = new JLabel("원하는 커피 선택");
		
		JRadioButton button1 = new JRadioButton("아메리카노(2500)");
		JRadioButton button2 = new JRadioButton("카페모카(3500)");
		JRadioButton button3 = new JRadioButton("에스프레소(2500)");
		JRadioButton button4 = new JRadioButton("카페라떼(4000)");
		
		ButtonGroup BGroup = new ButtonGroup();
		BGroup.add(button1);
		BGroup.add(button2);
		BGroup.add(button3);
		BGroup.add(button4);
		
		JLabel label1 = new JLabel("수량: ");
		JTextField amount = new JTextField(5);
		JLabel label2 = new JLabel("입금액: ");
		JTextField money = new JTextField(5);
		
		JTextArea blank = new JTextArea(10,20);
		JScrollPane jsp = new JScrollPane(
				blank,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		
		container1.add(title);
		
		container2.add(button1);
		container2.add(button2);
		container2.add(button3);
		container2.add(button4);
		
		container3.add(label1);
		container3.add(amount);
		container3.add(label2);
		container3.add(money);
		
		container4.add(result);
		container4.add(exit);
		container4.add(cancel);
		
		JPanel group1 = new JPanel(new BorderLayout());
		
		group1.add(container3, BorderLayout.NORTH);
		group1.add(jsp, BorderLayout.CENTER);
		group1.add(container4, BorderLayout.SOUTH);
		
		add(container1,BorderLayout.NORTH);
		add(container2,BorderLayout.CENTER);
		add(group1,BorderLayout.SOUTH);
		
		setBounds(200,200,400,500);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam03();
	}
}
