package project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;

public class G_Bilge extends JFrame {
	ImageIcon icon;
	int pay;
	int sum;
	String change;
	
	
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
					G_Bilge frame = new G_Bilge();
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
	public G_Bilge() {
		change = Integer.toString(G_calculator.cash);
	
		setTitle("영수증");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
			pay = G_calculator.pay;
			
			sum = Integer.parseInt(change) - pay;
			
		
		

		
	}
	// 현금 계산
	void cash() {
		// 이미지 패널에 삽입
			icon = new ImageIcon("image/money.png");
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
						
			JLabel lblNewLabel = new JLabel("거스름돈");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
			lblNewLabel.setBounds(220, 40, 100, 56);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(Integer.toString(sum));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(320, 40, 127, 56);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("결제가 완료되었습니다");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(215, 120, 185, 15);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("거스름돈을 받아가세요");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
			lblNewLabel_2_1.setBounds(215, 150, 185, 15);
			contentPane.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_2_2 = new JLabel("이용해주셔서 감사합니다.");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
			lblNewLabel_2_2.setBounds(215, 180, 185, 20);
			contentPane.add(lblNewLabel_2_2);
	}
		
	void card() {
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
					
					JLabel lblNewLabel_2 = new JLabel("결제가 완료되었습니다");
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(230, 80, 160, 15);
					contentPane.add(lblNewLabel_2);
					
					JLabel lblNewLabel_2_1 = new JLabel("영수증을 받아가세요");
					lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_2_1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
					lblNewLabel_2_1.setBounds(230, 110, 160, 15);
					contentPane.add(lblNewLabel_2_1);
					
					JLabel lblNewLabel_2_2 = new JLabel("이용해주셔서 감사합니다.");
					lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_2_2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
					lblNewLabel_2_2.setBounds(215, 140, 200, 20);
					contentPane.add(lblNewLabel_2_2);
	}

	
}

