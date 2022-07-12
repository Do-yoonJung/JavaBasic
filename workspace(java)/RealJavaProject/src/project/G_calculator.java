package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

public class G_calculator extends JFrame {

	Connection con = null;					//DB와 연결하는 객체
	PreparedStatement pstmt = null;			//SQL문을 DB에 전송하는 객
	ResultSet rs = null;					//SQL문 실행 결과를 가지고 있는 객체
	String sql = null;						//SQL문을 저장하는 문자열 변수
	static int cash;
	static int sum = 0;
	String car_num;
	Date in_car;
	Date out_car;
	int pTime;
	static int pay;
	static int pbalance;
	int pday;
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					
					G_calculator frame = new G_calculator();
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
	public G_calculator() {
		// 조회 메서드 호출
		select();
		
		setTitle("비회원 요금 계산서");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("차량 번호");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 33, 97, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("입차 시간");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 58, 97, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("주차 시간");
		lblNewLabel_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(20, 112, 97, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("출차 시간");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 87, 97, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("요       금");
		lblNewLabel_1_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(20, 137, 97, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("현금 결제");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(56, 179, 129, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("카드 결제");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton_1.setBounds(244, 179, 129, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(Integer.toString(pay));
		lblNewLabel_1_1_1_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setBounds(143, 137, 212, 15);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(Integer.toString(pTime));
		lblNewLabel_1_1_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setBounds(143, 112, 212, 15);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(out_car.toString());
		lblNewLabel_2_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(143, 87, 212, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(in_car.toString());
		lblNewLabel_1_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(143, 58, 212, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel(car_num);
		lblNewLabel_3.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(143, 33, 212, 15);
		contentPane.add(lblNewLabel_3);
		
		// 현금결제 버튼 클릭 시
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cash = Integer.parseInt(JOptionPane.showInputDialog("결제하실 금액을 넣어주세요"));
				while (cash < pay) {
					JOptionPane.showMessageDialog(null, "결제금액이 모자랍니다");
					cash = Integer.parseInt(JOptionPane.showInputDialog("결제하실 금액을 넣어주세요"));
				}
				if(cash > pay) {
					new G_Bilge().cash();
					out();
					dispose();
				}
			}
				
			
		});
		
		// 카드결제 버튼 클릭 시
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "카드를 넣어주세요","확인",JOptionPane.YES_NO_OPTION);
	            if(result == JOptionPane.YES_OPTION) {
	               new G_Bilge().card();
	               out();
	               dispose();
	            }else {
	               JOptionPane.showMessageDialog(null, "결제가 취소되었습니다");
	            }
			}
		});
	}
	void select() {
		try {
			con=DBConnection.getConnection();
			sql="select*from parking where car_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Out.ID);
			rs=pstmt.executeQuery();
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
