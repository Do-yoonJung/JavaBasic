package project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;

public class Bilge extends JFrame {
	ImageIcon icon;
	int car_num;
	int pbalance;
	String carNum;
	String ID;
	int pay;
	
	
	Connection con = null;				// DB와 연결하는 객체
	PreparedStatement pstmt = null;		// SQL문을 DB에 전송하는 객체
	ResultSet rs = null;				// SQL문 실행 결과를 가지고있는 객체
	String sql = null;					// SQL문을 저장하는 문자열 변수
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Bilge frame = new Bilge();
					Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
					UIManager.put("OptionPane.messageFont", f1);
					UIManager.put("OptionPane.buttonFont", f1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bilge() {
		balance();
		payment();
		setTitle("영수증");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 이미지 패널에 삽입
		icon = new ImageIcon("image/invoice.png");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
	            // Approach 2: Scale image to size of component
	             Dimension d = getSize();
	             g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	            // Approach 3: Fix the image position in the scroll pane
	            // Point p = scrollPane.getViewport().getViewPosition();
	            // g.drawImage(icon.getImage(), p.x, p.y, null);
	            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	            super.paintComponents(g);
	        }
		};
		
		
    
		panel.setBounds(12, 24, 179, 211);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("잔 액");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(223, 39, 71, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(pbalance));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(306, 39, 97, 56);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("결제가 완료되었습니다");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(197, 121, 219, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("영수증을 받아가세요");
		lblNewLabel_2_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(203, 149, 207, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("이용해주셔서 감사합니다.");
		lblNewLabel_2_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(213, 176, 186, 15);
		contentPane.add(lblNewLabel_2_2);
	}
	// 잔액 - 요금 DB반영
	void balance() {
		try {
			pay = Calculator.pay;
			pbalance = Calculator.pbalance;
			pbalance = pbalance - pay;
			con = DBConnection.getConnection();
			sql="update p_member set balance = ? where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pbalance);
			pstmt.setString(2, Out.ID);
			rs = pstmt.executeQuery();
			rs.close(); pstmt.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 수정된 잔액 조회
	void payment() {
		try {
			con=DBConnection.getConnection();
			sql="select balance from p_member where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Out.ID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pbalance = rs.getInt("balance");
				
				
				
			}
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
}
}
