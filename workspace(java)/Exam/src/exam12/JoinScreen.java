package exam12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JoinScreen extends JFrame {

	public JoinScreen() {
		
		setTitle("제품관리 시스템");
		
		JLabel label1 = new JLabel("회원가입");
		JRadioButton button1 = new JRadioButton("고객");
		JRadioButton button2 = new JRadioButton("관리자");
		JRadioButton button3 = new JRadioButton("기타");
		ButtonGroup bg = new ButtonGroup();
		bg.add(button1);
		bg.add(button2);
		bg.add(button3);
		JLabel label2 = new JLabel("아이디: ");
		JTextField ID = new JTextField(10);
		JLabel label3 = new JLabel("비밀번호: ");
		JTextField PW = new JTextField(10);
		JLabel label4 = new JLabel("이름: ");
		JTextField name = new JTextField(10);
		JLabel label5 = new JLabel("전화번호: ");
		JTextField phone = new JTextField(10);
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton("취소");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		JPanel container5 = new JPanel();
		JPanel container6 = new JPanel();
		JPanel container7 = new JPanel();
		
		container1.add(label1);
		container2.add(button1);
		container2.add(button2);
		container2.add(button3);
		container3.add(label2);
		container3.add(ID);
		container4.add(label3);
		container4.add(PW);
		container5.add(label4);
		container5.add(name);
		container6.add(label5);
		container6.add(phone);
		container7.add(join);
		container7.add(cancel);
		
		JPanel group1 = new JPanel(new BorderLayout());
		group1.add(container5, BorderLayout.NORTH);
		group1.add(container6, BorderLayout.CENTER);
		group1.add(container7, BorderLayout.SOUTH);
		JPanel group2 = new JPanel(new BorderLayout());
		group2.add(container2, BorderLayout.NORTH);
		group2.add(container3, BorderLayout.CENTER);
		group2.add(container4, BorderLayout.SOUTH);
		
		add(container1, BorderLayout.NORTH);
		add(group2, BorderLayout.CENTER);
		add(group1, BorderLayout.SOUTH);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		label1.setFont(new Font("궁서체", Font.BOLD, 25));
		label1.setForeground(Color.BLUE);
		
		//회원가입 이벤트
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String inputId = ID.getText();
				String inputPw = PW.getText();
				String inputName = name.getText();
				String inputPhone = phone.getText();
				String type = null;
				
				if(button1.isSelected()) {
					type = "고객";
				}else if(button2.isSelected()) {
					type = "관리자";
				}else if(button3.isSelected()) {
					type = "기타";
				}
				
				JOptionPane.showMessageDialog(null, type + "를(을) 선택했군요");
				JOptionPane.showMessageDialog
				(null, inputId + inputPw + inputName + inputPhone + type);
			}
		});
		
		//취소 이벤트
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginScreen();
			}
		});
		
	}
	
	public static void main(String[] args) {
		new JoinScreen();
	}

}
