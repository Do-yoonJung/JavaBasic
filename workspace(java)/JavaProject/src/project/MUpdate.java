package project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class MUpdate extends JFrame{
	Connection con = null;          // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체 
	ResultSet rs = null;            // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;              // SQL문을 저장하는 문자열 변수
	
	DefaultTableModel model;
	JTable table;
	JTextField jtfCarNum, jtfName, jtfPhone, jtfRecharge, jtfBalance, jtfPwd;
	
	Scanner sc = new Scanner(System.in);
	
	
	public MUpdate() {
		try {
			con = DBConnection.getConnection(); // 데이터베이스 연결!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setTitle("회원정보 수정");
		JPanel container1 = new JPanel(); // 상단-1 컨테이너
		JPanel container2 = new JPanel(); // 상단-2 컨테이너
		JPanel container3 = new JPanel(); // 하단 컨테이너
		
		// 
		JLabel jlCarNum = new JLabel("차번호(ID) : ");
		jlCarNum.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfCarNum = new JTextField(10);

		JLabel jlName = new JLabel("이름 : ");
		jlName.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfName = new JTextField(5);
		
		JLabel jlPhone = new JLabel("전화번호 : ");
		jlPhone.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfPhone = new JTextField(12);

		JLabel jlPwd = new JLabel("비밀번호 : ");
		jlPwd.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfPwd = new JTextField(15);	
		
		jtfCarNum.setText(LogIn.searchedId);		//차량번호 확인

		
		
		// header
		String[] header = {"차번호", "이름", "전화번호", "비밀번호"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(
				table, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		// 버튼
//		JButton jbMemI = new JButton("회원 조회");
//		jbMemI.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		JButton jbMemUpdate = new JButton("회원 정보 수정");
		jbMemUpdate.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		JButton jbBack = new JButton("이전으로");
		jbBack.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		
		// 상단 -1 : 차번호, 이름, 전화번호
		container1.add(jlCarNum); container1.add(jtfCarNum);
		container1.add(jlName); container1.add(jtfName);

		jtfCarNum.setText(LogIn.searchedId);	//차량번호
		
		// 상단-2 : 충전금액, 잔액, 비밀번호
		container2.add(jlPhone); container2.add(jtfPhone);
		container2.add(jlPwd); container2.add(jtfPwd);
		
		// 하단 : 버튼
//		container3.add(jbMemI);
		container3.add(jbMemUpdate);
		container3.add(jbBack);

	
		
		// 새로운 컨테이너를 생성
		JPanel group = new JPanel(new BorderLayout());
		
		group.add(container2, BorderLayout.NORTH);
		group.add(jsp, BorderLayout.CENTER);
		group.add(container3, BorderLayout.SOUTH);
	
		getContentPane().add(container1, BorderLayout.NORTH);
		getContentPane().add(group, BorderLayout.CENTER);
		
		// 크기 조절
		setBounds(200, 200, 650, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
		JOptionPane.showMessageDialog(null, "차량번호는 수정 불가합니다\n관리자에게 문의하세요");
		select();
		
		
		
		
		//이벤트 처리중
		//회원조회
//		jbMemI.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				jtfCarNum.setText(LogIn.searchedId);
//				
//				select();	//조회
//			}
//		});
		
		
		//수정
		jbMemUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				update(); // 메서드 호출
				
				//초기화
//				jtfCarNum.setText(""); 
				jtfName.setText("");
				jtfPhone.setText(""); jtfPwd.setText("");
				jtfCarNum.requestFocus(); 
		
				model.setRowCount(0);
				select();

								
			}
		});
		
		
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}	
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow(); // 하나의 행 선택
				jtfCarNum.setText(model.getValueAt(row, 0).toString());
				jtfName.setText(model.getValueAt(row, 1).toString());
				jtfPhone.setText(model.getValueAt(row, 2).toString());
				jtfPwd.setText(model.getValueAt(row, 3).toString());
				
			}
		});
		
		//이전으로
		jbBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClientMenu();
				dispose();
				
			}
		});
		
	
	}
	//메서드
	void select() {
		
		try {
			//오라클 데이터베이스에 전송할 SQL문을 작성
			
			sql = "select car_num, memname, phone, pwd from p_member where car_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jtfCarNum.getText());	
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
			String car_num = rs.getString("car_num");
			String memname = rs.getString("memname");
			String phone = rs.getString("phone");
			String pwd = rs.getString("pwd");
			
			Object[] data = {car_num, memname, phone, pwd};
			model.addRow(data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	void update() {


		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
				sql = "update p_member set memname =?, phone =?, pwd =? where car_num =?";

			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
				pstmt = con.prepareStatement(sql);
	
				pstmt.setString(1, jtfName.getText());
				pstmt.setString(2, jtfPhone.getText());
				pstmt.setString(3, jtfPwd.getText());
				pstmt.setString(4, LogIn.searchedId);
				
				int rs = pstmt.executeUpdate();
				
				if(rs > 0) {
				
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					
				}else {
					JOptionPane.showMessageDialog(null, "수정 실패");
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new MUpdate();
			Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
			UIManager.put("OptionPane.messageFont", f1);
			UIManager.put("OptionPane.buttonFont", f1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
