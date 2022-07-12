package project;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Out extends JFrame {
	
	Connection con = null;					//DB와 연결하는 객체
	PreparedStatement pstmt = null;			//SQL문을 DB에 전송하는 객
	ResultSet rs = null;					//SQL문 실행 결과를 가지고 있는 객체
	String sql = null;						//SQL문을 저장하는 문자열 변수
	JPasswordField jpf;
	String carNum;
	String FNum;
	int amount;
	static String ID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Out frame = new Out();
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
	public Out() {
		setTitle("차량번호 검색");
		
		JPanel container1 = new JPanel();
		container1.setBounds(0, 0, 286, 32);
		JPanel container2 = new JPanel();
		container2.setBounds(0, 26, 286, 111);
		JPanel container3 = new JPanel();
		container3.setBounds(0, 137, 286, 42);
		
		jpf = new JPasswordField(4);
		jpf.setEchoChar('*');
		jpf.setFont(new Font("나눔고딕", Font.BOLD, 100));
		jpf.setBounds(55, 35, 180, 75);
		
		JButton cancel = new JButton("취소");
		cancel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		JButton OK = new JButton("확인");
		OK.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		ButtonGroup BGroup = new ButtonGroup(); 
		BGroup.add(cancel);
		BGroup.add(OK);
		
		container2.setLayout(null);
		container2.add(jpf);
		
		container3.add(cancel);
		container3.add(OK);
		getContentPane().setLayout(null);
		
		
		getContentPane().add(container1);
		getContentPane().add(container2);
		
		JLabel jl = new JLabel("차량번호 4자리를 입력해주세요.");
		jl.setBounds(39, 1, 230, 22);
		container2.add(jl);
		jl.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		getContentPane().add(container3);
		
		setBounds(200,200,300,222);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//취소 이벤트 -> 첫페이지로 돌아가기
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FirstPage();
				dispose();
			}
		});
		
		//확인 이벤트
		//1. 존재하는 차량 중복 X -> 차량번호 확인창
		//2. 존재하는 차량 중복 O -> 차량번호 선택창
		//3. 존재하지 않는 차량 -> 존재하지 않는 번호입니다.
		//1-1. carNum 에서 차량번호 가져와서 DB에서 검색
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String FNum = new String(jpf.getPassword());
				equal(FNum);
				
			}
		});
	}// 생성자 END
	
	// DB에서 차량번호 검색하는 메서드
	//1. 존재하는 차량 중복 X -> 차량번호 확인창
	//2. 존재하는 차량 중복 O -> 차량번호 선택창
	//3. 존재하지 않는 차량 -> 존재하지 않는 번호입니다.
	//1-1. carNum 에서 차량번호 가져와서 DB에서 검색
	
	//2. 차량번호가 중복일 때 리스트 불러오기
	void equal(String no) {
		try {
			con = DBConnection.getConnection();
			sql = "select count(car_num) as amount from parking where substr(car_num, -4, 4) = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			String[] list = null;
			
			if(rs.next()) {
				amount = rs.getInt("amount");
				if(amount > 1) {
					sql = "select car_num from parking where substr(car_num, -4, 4) = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, no);
					rs = pstmt.executeQuery();
					
					//팝업 옵션 배열 선언
					list = new String[amount];
					int i = 0;
					//팝업 옵션 내용을 배열에 저장
					while(rs.next()) {
						list[i] = rs.getString("car_num");
						i++;	
					}
					
					//옵션을 정하고 OK를 누르면 옵션의 내용을 Object형으로 전달하므로 문자열로 형 변환
					ID = (String)JOptionPane.showInputDialog
							(null, "차량 번호를 선택하세요.", "경고", JOptionPane.OK_CANCEL_OPTION, 
									null, list, list[0]);
					
					int result = 0;
					
					if(ID == null) {
						JOptionPane.showMessageDialog(null, "차량번호를 입력하세요.");
						jpf.setText(null);
						jpf.requestFocus();
					}else {
						result = JOptionPane.showConfirmDialog(null, "고객님의 차량 번호가 " 
								+ ID + " 이 맞습니까?","확인",JOptionPane.YES_NO_OPTION);
					}
							
					if(result == JOptionPane.YES_OPTION) {
						outTime(ID);
						pcharge(ID);
						//new Calculator();
						//dispose();
					}
				}else if(amount == 1){
					
					sql = "select car_num from parking where substr(car_num, -4, 4) = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, no);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						ID = rs.getString("car_num");
						
						int result = JOptionPane.showConfirmDialog(null, "고객님의 차량 번호가 " 
						+ ID + " 이 맞습니까?","확인",JOptionPane.YES_NO_OPTION);
						
						if(result == JOptionPane.YES_OPTION) {
							outTime(ID);
							pcharge(ID);//new Calculator();
							//dispose();
						}
					}
				}else if(amount == 0){
					search(ID);
				}
				rs.close(); pstmt.close();con.close();
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void search(String no) {
		
		try {
			con = DBConnection.getConnection();
			sql = "select car_num from parking where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ID = rs.getString("car_num");
				
				int result = JOptionPane.showConfirmDialog(null, "고객님의 차량 번호가 " 
				+ ID + " 이 맞습니까?","확인",JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					outTime(ID);
					pcharge(ID);//new Calculator();
					//dispose();
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "존재하지 않는 차량입니다.");
				jpf.setText(null);
				jpf.requestFocus();
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void pcharge(String no) {
		
		try {
					
			//회원 가입 여부 확인
			sql = "select mem_y from parking where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mem_y = rs.getString("mem_y");
				
				if(mem_y.equalsIgnoreCase("y")) {
					new Calculator();
					dispose();
				}else if(mem_y.equalsIgnoreCase("n")) {
					new G_calculator();
					dispose();
				}
			}
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void outTime(String no) {
		
		try {
			con = DBConnection.getConnection();
			sql = "update parking set out_car = sysdate where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			rs.close(); pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
