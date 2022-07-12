package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Calculator extends JFrame {

	private JPanel contentPane;

	Connection con = null;					//DB와 연결하는 객체
	PreparedStatement pstmt = null;			//SQL문을 DB에 전송하는 객
	ResultSet rs = null;					//SQL문 실행 결과를 가지고 있는 객체
	String sql = null;						//SQL문을 저장하는 문자열 변수
	
	String car_num;
	Date in_car;
	Date out_car;
	int pTime;
	static int pay;
	static int pbalance;
	String searchedId;
	int pday;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Calculator frame = new Calculator();
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
	public Calculator() {
		
		
		select();
		balance();
		
		setTitle("요금 계산서");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("차량 번호");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 26, 90, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("입차 시간");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 51, 90, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("출차 시간");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 76, 90, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주차 시간");
		lblNewLabel_3.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 101, 90, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("요       금");
		lblNewLabel_4.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 146, 90, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("잔       액");
		lblNewLabel_4_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(12, 174, 90, 15);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel(car_num);
		lblNewLabel_5.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(114, 26, 173, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel(in_car.toString());
		lblNewLabel_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(114, 51, 173, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(out_car.toString());
		lblNewLabel_2_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(114, 76, 173, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel(Integer.toString(pTime));
		lblNewLabel_3_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(114, 101, 173, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel(Integer.toString(pay));
		lblNewLabel_4_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(114, 146, 173, 15);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel(Integer.toString(pbalance));
		lblNewLabel_4_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(114, 174, 173, 15);
		contentPane.add(lblNewLabel_4_1_1);
		
		JButton btnNewButton = new JButton("정액 충전");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(275, 22, 132, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("결제하기");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton_1.setBounds(275, 146, 132, 47);
		contentPane.add(btnNewButton_1);
		
		// 정액충전 버튼 클릭 시
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Charge();
				balance();
			}
		});
		
		// 결제하기 버튼 클릭 시
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pay <= pbalance) {
					new Bilge();
					out();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다");
					new Charge();
					dispose();
				}
				
			}
		});
	}
	
	void select() {
		try {
			con=DBConnection.getConnection();
			sql="select * from parking where car_num= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Out.ID);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				car_num = rs.getString("car_num");
				in_car = rs.getDate("in_car");
				out_car = rs.getDate("out_car");
				pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
				pay = pTime * 50;
				if(pay>=50000) {
					pday = (int)((out_car.getTime()-in_car.getTime())/(24*60*60*1000));
					if(pday>=1) {
						pay = 0;
						// pTime -= (1440*pday); 
						pay = ((((pTime-(1440*pday))*50))+pday*50000);
						if(((pTime-(1440*pday))*50)>=1000){
							pay = (pday+1)*50000;
						}
					}
				}
				
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void balance() {
		try {
			con=DBConnection.getConnection();
			sql="select balance from p_member where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Out.ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pbalance = rs.getInt("balance");
				
			}
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void out() {
		try {
			con=DBConnection.getConnection();
			sql = "update parking set out_car = sysdate, out_ox = 'o' where car_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Out.ID);
			int res = pstmt.executeUpdate();
			pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
