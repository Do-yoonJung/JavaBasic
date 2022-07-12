package project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import oracle.net.aso.l;
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
	JTextField jtfCarNum, jtfName, jtfPhone, jtfRecharge, jtfBalance, jtfPwd, searchbar;
	
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
		JPanel container3 = new JPanel(); // 상단-3 컨테이너
		JPanel container4 = new JPanel(new BorderLayout()); // 하단 컨테이너
		
		// 
		JLabel jlCarNum = new JLabel("차량번호 : ");
		jlCarNum.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfCarNum = new JTextField(10);

		JLabel jlName = new JLabel("이름 : ");
		jlName.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfName = new JTextField(10);
		
		JLabel jlPhone = new JLabel("전화번호 : ");
		jlPhone.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfPhone = new JTextField(15);

		JLabel jlRecharge = new JLabel("충전금액 : ");
		jlRecharge.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfRecharge = new JTextField(10);
		
		JLabel jlBalance = new JLabel("잔액 : ");
		jlBalance.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfBalance = new JTextField(10);
		
		JLabel jlPwd = new JLabel("비밀번호 : ");
		jlPwd.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtfPwd = new JTextField(15);	
		
		searchbar = new JTextField(20);
		JButton jbSearch = new JButton("검색");
		jbSearch.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
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
		
		// 검색 부분
		container3.add(searchbar); container3.add(jbSearch);
		
		JPanel group1 = new JPanel(new BorderLayout());
		group1.add(container1, BorderLayout.NORTH);
		group1.add(container2, BorderLayout.CENTER);
		group1.add(container3, BorderLayout.SOUTH);
		
		// 하단 : 버튼
		JPanel container4_1 = new JPanel();
		JPanel container4_2 = new JPanel();
		container4_1.add(jbMemAll); container4_1.add(jbMemInsert); 
		container4_1.add(jbMemUpdate); container4_1.add(jbMemDelete);
		container4_2.add(jb2);
		
		container4.add(container4_1, BorderLayout.NORTH);
		container4.add(container4_2, BorderLayout.CENTER);
		
		
		// 새로운 컨테이너를 생성
		JPanel group = new JPanel(new BorderLayout());
		
		group.add(group1, BorderLayout.NORTH);
		group.add(jsp, BorderLayout.CENTER);
		group.add(container4, BorderLayout.SOUTH);
	
		getContentPane().add(group1, BorderLayout.NORTH);
		getContentPane().add(group, BorderLayout.CENTER);
		
		// 크기 조절
		setBounds(200, 200, 650, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		select(); // -- 창이 뜨자마자 목록이 보이게 하고 싶은 경우
		
		// 검색버튼
		jbSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				memSearch();
				
			}
		});
		
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
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "상단에 회원 정보를 입력해주세요");
				}else {
					memInsert(); // 메서드 호출
					
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
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "상단에 회원 정보를 입력해주세요");
				}else {
					update(); // 메서드 호출
					
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
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "선택하신 회원이 없습니다.");
				}else {
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow(); // 하나의 행 선택
				jtfCarNum.setText(model.getValueAt(row, 0).toString());
				jtfName.setText(model.getValueAt(row, 1).toString());
				jtfPhone.setText(model.getValueAt(row, 2).toString());
				String recharge = model.getValueAt(row, 3).toString();
				jtfRecharge.setText(recharge.substring(0, recharge.length()-2));
				String balance = model.getValueAt(row, 4).toString();
				jtfBalance.setText(balance.substring(0, balance.length()-2));
				jtfPwd.setText(model.getValueAt(row, 5).toString());
			}
		});
		
		jsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jtfCarNum.setText(""); jtfName.setText(""); jtfPhone.setText(""); 
				jtfRecharge.setText(""); jtfBalance.setText(""); jtfPwd.setText("");
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
			sql = "select car_num from p_member where car_num = '"+car_num+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 회원입니다.");
			}else {
				String sql1 = "select car_num from parking where car_num = '"+car_num+"'";
				pstmt = con.prepareStatement(sql1);
				ResultSet rs1 = pstmt.executeQuery();
				if (rs1.next()) { 
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
			}
			
			
			
			if (res > 0) {
				JOptionPane.showMessageDialog(null, "회원을 등록하였습니다.");
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
	
	// 검색메서드
	void memSearch(){
		try {
			String keyword = searchbar.getText();
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from p_member where "
				    + "car_num like'" + keyword + "%' or "
				    + "memname like'" + keyword + "%' or "               
				    + "phone like'" + keyword + "%'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
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
			rs.close(); pstmt.close(); // con.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
