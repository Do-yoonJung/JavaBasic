package exam11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Exam03 extends JFrame {

	public Exam03() {
		setTitle("원하는 커피 선택");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		JLabel title = new JLabel("원하는 커피 선택");
		
		JRadioButton button1 = new JRadioButton("아메리카노(2500)");
		JRadioButton button2 = new JRadioButton("카페모카(3500)");
		JRadioButton button3 = new JRadioButton("에스프레소(2500)");
		JRadioButton button4 = new JRadioButton("카페라떼(4000)");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(button1);
		bg.add(button2);
		bg.add(button3);
		bg.add(button4);
		
		JLabel label1 = new JLabel("수량: ");
		JTextField amount = new JTextField(5);
		JLabel label2 = new JLabel("입금액: ");
		JTextField money = new JTextField(10);
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		JButton newWindow = new JButton("새창");
		
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
		container4.add(newWindow);
		
		JPanel group1 = new JPanel(new BorderLayout());
		JPanel group2 = new JPanel(new BorderLayout());
		
		group1.add(container3, BorderLayout.NORTH);
		group1.add(jsp, BorderLayout.CENTER);
		group1.add(container4, BorderLayout.SOUTH);
		
		group2.add(container1, BorderLayout.NORTH);
		group2.add(container2, BorderLayout.SOUTH);
		
		add(container1, BorderLayout.NORTH);
		add(group1, BorderLayout.CENTER);
		add(group2, BorderLayout.SOUTH);
		
		setBounds(200,200,300,300);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//계산 이벤트
		result.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				int am = Integer.parseInt(amount.getText());
				int m = Integer.parseInt(money.getText());
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Exam03();
	}

}
