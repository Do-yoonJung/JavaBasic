package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class LogIn extends JFrame {

	//DB
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	//검색된 아이디
	static String searchedId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					LogIn frame = new LogIn();
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
	public LogIn() {
		
		setTitle("로그인 창");
		
		JLabel title = new JLabel("로그인 화면");
		title.setBounds(90, 30, 200, 40);
		title.setFont(new Font("한컴 고딕", Font.BOLD, 30));
		
		JRadioButton client = new JRadioButton("회원");
		client.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JRadioButton manager = new JRadioButton("관리자");
		manager.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		ButtonGroup BGroup = new ButtonGroup();
		BGroup.add(client); BGroup.add(manager);
		
		JLabel jl1 = new JLabel("아이디: ");
		jl1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JTextField jtf1 = new JTextField(10);
		JLabel jl2 = new JLabel("비밀번호: ");
		jl2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JPasswordField jpf1 = new JPasswordField(10);
		
		JButton cancel = new JButton("취소");
		cancel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		cancel.setBounds(90, 5, 60, 40);
		JButton OK = new JButton("확인");
		OK.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		OK.setBounds(170, 5, 60, 40);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		radioPanel.add(client); radioPanel.add(manager);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(jl1); idPanel.add(jtf1);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(jl2); pwPanel.add(jpf1);
		
		//formPanel = id + pw
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(3,1));
		formPanel.add(radioPanel);
		formPanel.add(idPanel); formPanel.add(pwPanel);
		
		//contentPanel = formPanel + radioPanel
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(6, 74, 307, 140);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(formPanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(6, 209, 282, 51);
		btnPanel.setLayout(null);
		btnPanel.add(cancel); btnPanel.add(OK);
		getContentPane().setLayout(null);
		
		//north - title, center - contentPanel, south - btnPanel
		getContentPane().add(title);
		getContentPane().add(contentPanel);
		getContentPane().add(btnPanel);
		
		setBounds(200,200,350,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//확인 버튼 -> 회원메뉴 / 관리자메뉴
		//1. if 문으로 선택된 라디오버튼으로 조건걸기
		OK.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					con = DBConnection.getConnection();
					String id = new String(jtf1.getText());
					String pw = new String(jpf1.getPassword());
					
					if(client.isSelected()) { //고객 검색
						searchedId = searchClinet(id, pw);
						
						if(searchedId == null) {
							jtf1.setText(null);
							jpf1.setText(null);
							jtf1.requestFocus();
						}else {
							new ClientMenu();
							dispose();
						}
					}else if(manager.isSelected()) { //관리자 검색
						searchedId = searchManager(id, pw);
						if(searchedId == null) {
							jtf1.setText(null);
							jpf1.setText(null);
							jtf1.requestFocus();
						}else {
							new Manager();
							dispose();
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
	}//생성자 END
	
	// 회원정보 찾는 메서드
	//1. 자동차 번호 or 관리자 id 조회 
	//2. 비밀번호 조회
	String searchClinet(String Cid, String Cpw) {
		
		String car_num = null;
		try {
			sql = "select car_num from p_member where car_num = ? and pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Cid);
			pstmt.setString(2, Cpw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				car_num = rs.getString("car_num");
			}else {
				JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.\n다시 입력해주세요.");
			}
			rs.close(); pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car_num;
	}	
	
	String searchManager(String Mid, String Mpw) {
		String adminid = null;
		try {
			sql = "select adminid from admin where adminid = ? and adminpwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Mid);
			pstmt.setString(2, Mpw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adminid = rs.getString("adminid");
			}else {
				JOptionPane.showMessageDialog(null, "존재하지 않는 관리자입니다.\n다시 입력해주세요.");
			}
			
			rs.close(); pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminid;
	}
}
