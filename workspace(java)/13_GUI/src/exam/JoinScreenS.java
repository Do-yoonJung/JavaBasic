package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class JoinScreenS extends JFrame{

	public JoinScreenS() {
	
		setTitle("회원관리 화면");
		
		//1.컴포넌트
		JLabel title = new JLabel("회원가입", JLabel.CENTER);
		
		title.setForeground(new Color(5,0,153));
		title.setFont(new FontUIResource("휴먼편지체", Font.BOLD, 25));
		
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton("취소");
		
		JTextField id = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		JTextField name = new JTextField(10);
		JTextField phone = new JTextField(10);
		
		JRadioButton client = new JRadioButton("고객");
		JRadioButton manager = new JRadioButton("관리자");
		JRadioButton etc = new JRadioButton("기타");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(client);
		bg.add(manager);
		bg.add(etc);
		
		//radio panel
		JPanel radioPanel = new JPanel();
		radioPanel.add(client);
		radioPanel.add(manager);
		radioPanel.add(etc);
		
		//form panel
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아이디: "));
		idPanel.add(id);
		
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwdPanel.add(new JLabel("비밀번호: "));
		pwdPanel.add(pwd);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("이름: "));
		namePanel.add(name);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phonePanel.add(new JLabel("연락처: "));
		phonePanel.add(phone);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4,1));
		formPanel.add(idPanel);
		formPanel.add(pwdPanel);
		formPanel.add(namePanel);
		formPanel.add(phonePanel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(radioPanel);
		contentPanel.add(formPanel);
		
		JPanel panel = new JPanel();
		panel.add(join);
		panel.add(cancel);
		
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(200,200,250,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		client.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, client.getText() + "를 선택하셨군요");
			}
		});
		
		//이벤트 처리
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String myId = id.getText();
				String myPwd = new String(pwd.getPassword());
				String myName = name.getText();
				String myPhone = phone.getText();
				String choice = "";
				
				if(client.isSelected()) {
					choice = client.getText();
				}else if(manager.isSelected()) {
					choice = manager.getText();
				}else if(etc.isSelected()) {
					choice = etc.getText();
				}
				
				JOptionPane.showMessageDialog
				(null, "아이디: " + myId + ", 비밀번호: " + myPwd + ", 이름: " + myName
						+ ", 연락처: " + myPhone+ ", 가입유형: " + choice);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginScreenS();
				dispose();
			}
		});
	}
}
