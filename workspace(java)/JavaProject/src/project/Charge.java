package project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.*;

public class Charge extends JFrame{

	Connection con = null;					//DB와 연결하는 객체
	PreparedStatement pstmt = null;			//SQL문을 DB에 전송하는 객
	ResultSet rs = null;					//SQL문 실행 결과를 가지고 있는 객체
	String sql = null;						//SQL문을 저장하는 문자열 변수
	String sql2 = null;						//SQL문을 저장하는 문자열 변수
	
	JLabel jb1,jb2;
	JTextField jtf1, jtf2;
	

	public static void main(String[] args) {
	
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new Charge();
			
			Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
			UIManager.put("OptionPane.messageFont", f1);
			UIManager.put("OptionPane.buttonFont", f1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public Charge() {
	
	setTitle("회원권 충전");
	
	JPanel container1 = new JPanel();
	JPanel container2 = new JPanel();
	JPanel container3 = new JPanel();

	jb1 = new JLabel("충전 금액을 입력하세요");
	jb1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
	jb2 = new JLabel("차량 번호를 확인하세요");
	jb2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
	jtf1 = new JTextField(15);
	jtf2 = new JTextField(15);
	
	if(LogIn.searchedId != null) {
	      jtf2.setText(LogIn.searchedId);      
	   }else if(Out.ID != null) {
	      jtf2.setText(Out.ID);
	   }//차량번호 확인
	
	
	JButton button1 = new JButton("1,000원");
	button1.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button2 = new JButton("3,000원");
	button2.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button3 = new JButton("5,000원");
	button3.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button4 = new JButton("10,000원");
	button4.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button5 = new JButton("30,000원");
	button5.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button6 = new JButton("50,000원");
	button6.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button7 = new JButton("취소");
	button7.setFont(new Font("한컴 고딕", Font.BOLD, 25));
	JButton button8 = new JButton("확인");
	button8.setFont(new Font("한컴 고딕", Font.BOLD, 25));

	
	//컨테이너 배치
	
	container1.add(jb1); 	container1.add(jtf1);
	container2.add(jb2); 	container2.add(jtf2);
	
	
	container3.add(button1);	container3.add(button2);
	container3.add(button3);	container3.add(button4);
	container3.add(button5);	container3.add(button6);
	container3.add(button7);	container3.add(button8);

	
	container3.setLayout(new GridLayout(4,2,2, 2));		
	
	
	JPanel group = new JPanel(new BorderLayout());
	
	group.add(container1, BorderLayout.NORTH);
	group.add(container2, BorderLayout.CENTER);
	
	getContentPane().add(group, BorderLayout.NORTH);
	getContentPane().add(container3, BorderLayout.CENTER);
	
	//이벤트처리
		//버튼 눌렀을 때 화면에 금액입력
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("1000");
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("3000");
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("5000");
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("10000");
			}
		});
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("30000");
			}
		});
		button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("50000");
			}
		});
		
		//취소버튼
		button7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClientMenu();
				dispose();
			}
		});

		//확인버튼
		button8.addActionListener(new ActionListener(){
	            
	            public void actionPerformed(ActionEvent e) {
	            	try {
						con = DBConnection.getConnection();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	int check = JOptionPane.showConfirmDialog
	            	(null, "충전하시겠습니까?","정액권 충전",JOptionPane.YES_NO_OPTION);    
	            	
	            	if(check == JOptionPane.YES_OPTION) {
	        
	            		pay();
	            		recharge();
	            		jtf1.setText("완료되었습니다.");
	            		
	            		if(ClientMenu.clicked > 0) {
		            		new ClientMenu();
		            		dispose();
	            		}else if(ClientMenu.clicked == 0) {
	            			dispose();
	            		}

	            	
	            	}else{
	        				jtf1.setText("금액을 입력해 주세요");
	        			}
	            } 
	        });

	setBounds(200, 200, 400, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	
	//결재수단(수정중)
	void pay() {
		String pay[]= {"현금","카드"};
		int way = JOptionPane.showOptionDialog
				(null, "결재수단을 선택해 주세요", "결제", 0, 0, null, pay, pay[1]);
			
		if(way == 1) {
			JOptionPane.showMessageDialog(null, "카드를 넣어주세요");
		}else{
			JOptionPane.showMessageDialog(null, "현금을 넣어주세요");
		}
	}	
	
	

	//DB에서 잔액 확인
	// 충전시 => 잔액+입력금액
	void recharge () {
		
		try {
			//1.오라클 데이터베이스에 전송할 SQL문을 작성
			//con=DBConnection.getConnection();
			sql = "update p_member set recharge = ?, balance = balance + ? where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(jtf1.getText()));
			pstmt.setInt(2, Integer.parseInt(jtf1.getText()));
			pstmt.setString(3, jtf2.getText());
			
			
			//오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			
			int rs = pstmt.executeUpdate();
				
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "충전되었습니다.");
				if(LogIn.searchedId == null) {
					new Calculator();
				}
			}else {
				JOptionPane.showMessageDialog(null, "충전 실패");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}



}
