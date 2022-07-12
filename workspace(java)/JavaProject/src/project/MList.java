package project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import project.Manager;

public class MList extends JFrame{
	Manager parking;// 관리자 (parking 객체)
	Connection con = null;          // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체 
	ResultSet rs = null;            // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;              // SQL문을 저장하는 문자열 변수
	
	int charge = 500;   // 기본요금
	
	DefaultTableModel model;
	JTable table;
	JTextField jtfCarNum, jtfName, jtfPhone, jtfRecharge, jtfBalance, jtfPwd;
	
	Scanner sc = new Scanner(System.in);
	
	public MList() {
		try {
			con = DBConnection.getConnection(); // 데이터베이스 연결!!
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("회원 관리 시스템");
		
		JPanel container1 = new JPanel(); // 상단-1 컨테이너
		JPanel container2 = new JPanel(); // 상단-2 컨테이너
		JPanel container3 = new JPanel(new BorderLayout()); // 하단 컨테이너
		
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

		JLabel jlRecharge = new JLabel("충전금액 : ");
		jlRecharge.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfRecharge = new JTextField(8);
		
		JLabel jlBalance = new JLabel("잔액 : ");
		jlBalance.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfBalance = new JTextField(8);
		
		JLabel jlPwd = new JLabel("비밀번호 : ");
		jlPwd.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfPwd = new JTextField(15);	
		
		// header
		String[] header = {"차번호", "이름", "전화번호", "충전금액", "잔액", "비밀번호"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(
				table, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 버튼
		JButton jbMemAll = new JButton("회원 목록");
		jbMemAll.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbMemInsert = new JButton("회원 등록");
		jbMemInsert.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbMemUpdate = new JButton("회원 정보 수정");
		jbMemUpdate.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbMemDelete = new JButton("회원 삭제");
		jbMemDelete.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jb2 = new JButton("이전으로");
		jb2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		// 상단 -1 : 차번호, 이름, 전화번호
		container1.add(jlCarNum); container1.add(jtfCarNum);
		container1.add(jlName); container1.add(jtfName);
		container1.add(jlPhone); container1.add(jtfPhone);
		
		// 상단-2 : 충전금액, 잔액, 비밀번호
		container2.add(jlRecharge); container2.add(jtfRecharge);
		container2.add(jlBalance); container2.add(jtfBalance);
		container2.add(jlPwd); container2.add(jtfPwd);
		
		// 하단 : 버튼
		JPanel container3_1 = new JPanel();
		JPanel container3_2 = new JPanel();
		container3_1.add(jbMemAll); container3_1.add(jbMemInsert); 
		container3_1.add(jbMemUpdate); container3_1.add(jbMemDelete);
		container3_2.add(jb2);
		
		container3.add(container3_1, BorderLayout.NORTH);
		container3.add(container3_2, BorderLayout.CENTER);
		
		
		// 새로운 컨테이너를 생성
		JPanel group = new JPanel(new BorderLayout());
		
		group.add(container2, BorderLayout.NORTH);
		group.add(jsp, BorderLayout.CENTER);
		group.add(container3, BorderLayout.SOUTH);
	
		getContentPane().add(container1, BorderLayout.NORTH);
		getContentPane().add(group, BorderLayout.CENTER);
		
		// 크기 조절
		setBounds(620, 280, 650, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		select(); // -- 창이 뜨자마자 목록이 보이게 하고 싶은 경우
		
		// 전체 회원 목록 버튼
		jbMemAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				select(); // p_member 테이블의 전체 목록을 조회하는 메서드
			}
		});
		
		// 회원 등록 버튼
		jbMemInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				memInsert(); // 메서드 호출
				
				// 초기화
				jtfCarNum.setText(""); jtfName.setText("");
				jtfPhone.setText(""); jtfRecharge.setText("");
				jtfBalance.setText(""); jtfPwd.setText("");
				jtfCarNum.requestFocus(); // 커서 깜빡임			
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드

				select(); // 전체리스트 메서드 호출
			}
		});
		
		// 회원 정보 수정 버튼
		jbMemUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				update(); // 메서드 호출
				
				// 초기화
				jtfCarNum.setText(""); jtfName.setText("");
				jtfPhone.setText(""); jtfRecharge.setText("");
				jtfBalance.setText(""); jtfPwd.setText("");
				jtfCarNum.requestFocus(); // 커서 깜빡임			
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드

				select(); // 전체리스트 메서드 호출
			}
		});
		
		// 회원 삭제 버튼 
		jbMemDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int result = JOptionPane.showConfirmDialog
						(null, "회원을 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소 하셨습니다.");
				}else if (result == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "취소 하셨습니다.");
				}else if (result == JOptionPane.YES_OPTION) {
					p_memberDelete(); // 메서드 호출
					
					// 초기화
					jtfCarNum.setText(""); jtfName.setText("");
					jtfPhone.setText(""); jtfRecharge.setText("");
					jtfBalance.setText(""); jtfPwd.setText("");
					jtfCarNum.requestFocus(); // 커서 깜빡임			
					model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
					select(); // 전체리스트 메서드 호출
				}
			}
		});
		
		//이전 버튼 클릭시 관리자메뉴로 돌아감
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manager();
				dispose();
				
			}
		});
		
		jsp.addMouseListener(new MouseListener() {
			
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
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0);
				select();
				jtfCarNum.setText(""); jtfName.setText(""); jtfPhone.setText(""); 
				jtfRecharge.setText(""); jtfBalance.setText(""); jtfPwd.setText("");
				
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
				jtfRecharge.setText(model.getValueAt(row, 3).toString());
				jtfBalance.setText(model.getValueAt(row, 4).toString());
				jtfPwd.setText(model.getValueAt(row, 5).toString());
				
			}
		});
		
	}
	
	// p_member 테이블  회원 정보 조회 메서드
	void select() {
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from p_member order by car_num";

			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_num = rs.getString("car_num");
				String memname = rs.getString("memname");
				String phone = rs.getString("phone");
				int recharge = rs.getInt("recharge");
				int balance = rs.getInt("balance");
				String pwd = rs.getString("pwd");
				
				Object[] data = {car_num, memname, phone, recharge +" 원", balance+" 원", pwd};
				
				//레코드 모델에 추가
				model.addRow(data);
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			rs.close(); pstmt.close(); con.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // select() 메서드 end
	
	
	// 회원 정보 등록 메서드 
	void memInsert() {
		try {
			String car_num = jtfCarNum.getText();
			String memname = jtfName.getText();
			String phone = jtfPhone.getText();
			int recharge = Integer.parseInt(jtfRecharge.getText());
			String pwd = jtfPwd.getText();
			
			int res = 0;
			
			sql = "select car_num from parking where car_num = '"+car_num+"'";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { 
				String sql2 = "update parking set mem_y = 'y' where car_num = '"+car_num+"'";
				pstmt = con.prepareStatement(sql2);
				int res1 = pstmt.executeUpdate();
				
				if (res1 > 0) {
					String sql3 = "insert into p_member values('"+car_num+"', '"+memname+"', '"+phone+"', "
							+ ""+recharge+", "+recharge+", '"+pwd+"')";
					pstmt = con.prepareStatement(sql3);
					res = pstmt.executeUpdate();
				}
				
			}else {
				String sql2 = "insert into parking values('"+car_num+"', sysdate, sysdate, 500, 'y', 'o')";
				pstmt = con.prepareStatement(sql2);
				int res1 = pstmt.executeUpdate();
				
				if (res1 > 0) {
					String sql3 = "insert into p_member values('"+car_num+"', '"+memname+"', '"+phone+"', "
							+ ""+recharge+", "+recharge+", '"+pwd+"')";
					pstmt = con.prepareStatement(sql3);
					res = pstmt.executeUpdate();
				}

			}
			
			if (res > 0) {
				JOptionPane.showMessageDialog(null, "회원을 등록하였습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "등록에 실패했습니다.");
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			pstmt.close(); //con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // insert 메서드 end
	
	
	// p_member 테이블 회원의 정보를 수정하는 메서드
	void update() {
		try {
			int row = table.getSelectedRow(); // 하나의 행 선택
			String car_num1 =  model.getValueAt(row, 0).toString();
			String car_num = jtfCarNum.getText();
			String memname = jtfName.getText();
			String phone = jtfPhone.getText();
			int recharge = Integer.parseInt(jtfRecharge.getText());
			int balance = Integer.parseInt(jtfBalance.getText());
			String pwd = jtfPwd.getText();
			
			// 1. SQL문 작성, 전송 및 실행 -- 
			String sql1 = "delete from p_member where car_num = '"+car_num1+"'";
			pstmt = con.prepareStatement(sql1);
			int res = pstmt.executeUpdate();
			
			if (res > 0) {
				String sql2 = "update parking set car_num = '"+car_num+"' where car_num = '"+car_num1+"'";
				pstmt = con.prepareStatement(sql2);
				res = pstmt.executeUpdate();
				if (res > 0) {
					String sql3 = "insert into p_member values('"+car_num+"', '"+memname+"', '"+phone+"', "
							+ ""+recharge+", "+balance+", '"+pwd+"')";
					pstmt = con.prepareStatement(sql3);
					res = pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "정보를 수정했습니다.");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "수정 실패");
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			pstmt.close(); // con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // update() 메서드 end
	
	
	// p_member 테이블 행 삭제 
	void p_memberDelete() {
		try {
			String car_num = jtfCarNum.getText();
				
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "delete from p_member where car_num = '"+car_num+"'";
			
			pstmt = con.prepareStatement(sql);
			
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 실행 
			int res = pstmt.executeUpdate();
			
			if (res > 0) {
				String sql2 = "update parking set mem_y = 'n' where car_num = '"+car_num+"'";
				pstmt = con.prepareStatement(sql2);
				JOptionPane.showMessageDialog(null, "회원을 삭제 했습니다.");
				res = pstmt.executeUpdate();
			}else {
				JOptionPane.showMessageDialog(null, "삭제 실패");
			}
			
			//select();
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			pstmt.close(); //con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // p_memberDelete 메서드 end
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new MList();
			Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
			UIManager.put("OptionPane.messageFont", f1);
			UIManager.put("OptionPane.buttonFont", f1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		


	}


}
