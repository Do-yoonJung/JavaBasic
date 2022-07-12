package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginScreenS extends JFrame{

	public LoginScreenS() {

		setTitle("제품관리 시스템");
		
		JPanel title = new JPanel();
		
		//title container에 들어갈 컴포넌트
		JLabel login = new JLabel("로그인 화면");
		
		login.setForeground(new Color(5,0,153));
		login.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		
		//컨테이너에 올리기
		title.add(login);
		
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(3,2));
		
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jl1 = new JLabel("아이디: ", JLabel.CENTER);
		idPanel.add(jl1);
		
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);
		idPanel.add(jtf1);
		
		container.add(idPanel); container.add(idPanel2);
		
		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jl2 = new JLabel("비밀번호: ", JLabel.CENTER);
		pwdPanel.add(jl2);
		
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField jtf2 = new JPasswordField(10);
		pwdPanel2.add(jtf2);
		
		container.add(pwdPanel); container.add(pwdPanel2);
		
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("로그인");
		
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton join = new JButton("회원가입");
		
		loginPanel.add(jLogin);
		loginPanel.add(join);
		
		container.add(loginPanel);
		container.add(joinPanel);
		
		JPanel jp2 = new JPanel();
		
		jp2.setLayout(new FlowLayout());
		jp2.add(container);
		
		setLayout(new BorderLayout());
		
		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		
		setBounds(200,200,300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//이벤트 처리
		jLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				String myId = jtf1.getText();
				String myPwd = new String(jtf2.getPassword());
				
				JOptionPane.showMessageDialog(null, "아이디: " + myId + ", 비번: " + myPwd);
				
			}
		});
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				new JoinScreenS();
				dispose();  	//현재의 Frame을 종료시키는 메서드
			}
		});
	}
	
}
