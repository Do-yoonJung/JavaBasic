package exam12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginScreen extends JFrame {

	
	public LoginScreen() {
		
		setTitle("제품관리 시스템");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		JLabel label1 = new JLabel("로그인 화면");
		JLabel label2 = new JLabel("아이디: ");
		JTextField ID = new JTextField(10);
		JLabel label3 = new JLabel("비밀번호: ");
		JTextField pass = new JTextField(10);
		JButton logIn = new JButton("로그인");
		JButton join = new JButton("회원가입");
		
		container1.add(label1);
		container2.add(label2);
		container2.add(ID);
		container3.add(label3);
		container3.add(pass);
		container4.add(logIn);
		container4.add(join);
		
		JPanel group = new JPanel(new BorderLayout());
		group.add(container2, BorderLayout.NORTH);
		group.add(container3, BorderLayout.CENTER);
		group.add(container4, BorderLayout.SOUTH);
		
		add(container1, BorderLayout.NORTH);
		add(group, BorderLayout.CENTER);
		add(container4, BorderLayout.SOUTH);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		label1.setFont(new Font("궁서체", Font.BOLD, 25));
		label1.setForeground(Color.BLUE);
		
		//이벤트 로그인
		logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String inputId = ID.getText();
				String inputPass = pass.getText();
				
				JOptionPane.showMessageDialog
				(null, "아이디: " + inputId + ", 비번: " + inputPass);
			}
		});
		
		//회원가입 이벤트
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new JoinScreen();
			}
		});
	}
	
	public static void main(String[] args) {
		new LoginScreen();
	}

}
