package project;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ClientMenu extends JFrame {

	Connection con = null;					//DB와 연결하는 객체
	PreparedStatement pstmt = null;			//SQL문을 DB에 전송하는 객
	ResultSet rs = null;					//SQL문 실행 결과를 가지고 있는 객체
	String sql = null;						//SQL문을 저장하는 문자열 변수
	
	String searchedId;
	static int clicked = 0;
	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ClientMenu frame = new ClientMenu();
					frame.setVisible(true);
					Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
					UIManager.put("OptionPane.messageFont", f1);
					UIManager.put("OptionPane.buttonFont", f1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientMenu() {
		
		setTitle("회원 메뉴");
		
		JPanel container = new JPanel();
		container.setBounds(30, 55, 211, 172);
		
		JLabel title = new JLabel("회원 메뉴");
		title.setBounds(65, 24, 150, 36);
		title.setFont(new Font("한컴 고딕", Font.BOLD, 30));
		
		JButton jb0 = new JButton("출차");
		jb0.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb0.setBounds(50, 20, 100, 30);
		JButton jb1 = new JButton("잔액확인");
		jb1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb1.setBounds(50, 50, 100, 30);
		JButton jb2 = new JButton("금액충전");
		jb2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb2.setBounds(50, 80, 100, 30);
		JButton jb3 = new JButton("정보수정");
		jb3.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb3.setBounds(50, 110, 100, 30);
		JButton cancel = new JButton("취   소");
		cancel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		cancel.setBounds(50, 140, 100, 30);
		
		ButtonGroup BGroup = new ButtonGroup();
		BGroup.add(jb0); BGroup.add(jb1); BGroup.add(jb2); BGroup.add(jb3); BGroup.add(cancel);
		container.setLayout(null);
		
		container.add(jb0); container.add(jb1); container.add(jb2); 
		container.add(jb3); container.add(cancel);
		getContentPane().setLayout(null);
		
		getContentPane().add(title);
		getContentPane().add(container);
		
		setBounds(200,200,281,284);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//출차 버튼
		jb0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new Out();
				dispose();
			}
		});
		//잔액확인 버튼
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				balance(LogIn.searchedId);
			}
		});
		
		//금액충전 버튼
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Charge();
				clicked++;
				dispose();
			}
		});
		
		//정보수정 버튼
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MUpdate();
				dispose();
				
			}
		});
		
		//취소 버튼
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FirstPage();
				dispose();
			}
		});
		
	}

	//잔액확인 메서드
	void balance(String searchedId) {
		
		String balance = null;
		
		try {
			con = DBConnection.getConnection();
			sql = "select balance, car_num from p_member where car_num = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchedId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				balance = rs.getString("balance");
				String car_num = rs.getString("car_num");
				JOptionPane.showMessageDialog
				(null, car_num + " 회원님의 잔액은 " + balance + "원 입니다.");
			}
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
