package project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import project.LogIn;

public class Manager extends JFrame{
	
	Connection con = null;          // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체 
	ResultSet rs = null;            // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;              // SQL문을 저장하는 문자열 변수
	
	int charge = 500;   // 기본요금
	
	DefaultTableModel model;
	JTable table;
	JTextField searchbar;
	Date now = new Date();
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			Manager parking = new Manager();
			
			Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
			UIManager.put("OptionPane.messageFont", f1);
			UIManager.put("OptionPane.buttonFont", f1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Manager() {
	
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("주차장 관리 시스템_관리자");
		
		JPanel container1 = new JPanel(); // 서쪽 컨테이너
		JPanel container2 = new JPanel(new BorderLayout()); // 동쪽 컨테이너
		
		// 상단 컴포넌트
		JButton jbAll = new JButton("전체");
		jbAll.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbStand = new JButton("대기");
		jbStand.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbFinish = new JButton("완료");
		jbFinish.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		JLabel jlSearch = new JLabel("차량 검색  : ");
		jlSearch.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		searchbar = new JTextField(12);
		JButton jbSearch = new JButton("검색");
		jbSearch.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		// 서쪽 컴포넌트
		JButton jbInCar = new JButton("차량입차");
		jbInCar.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbOutCar = new JButton("차량출차");
		jbOutCar.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbMemList = new JButton("회원목록");
		jbMemList.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton btn_sales = new JButton("매출현황");
		btn_sales.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton btn_back = new JButton("로그아웃");
		btn_back.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		// 가운데 컴포넌트
		// header
		String[] header = {"차번호", "입차시간", "출차시간", "주차시간", "기본요금", "주차요금", "회원여부", "출차여부"};
		model = new DefaultTableModel(header, 0);
		
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(
				table, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 하단 컴포넌트
		JButton searchCarMem = new JButton("회원 차량 조회");
		searchCarMem.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton searchCarNotMem = new JButton("비회원 차량 조회");
		searchCarNotMem.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JButton jbDelete = new JButton("삭제");
		jbDelete.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		
		/**************************************컴포넌트 배치******************************************/
		// 서쪽 : 입차, 출차, 회원목록
		Box box1 = Box.createVerticalBox();	
//		jbInCar.setAlignmentX(CENTER_ALIGNMENT);
//		jbOutCar.setAlignmentX(CENTER_ALIGNMENT);
//		jbMemList.setAlignmentX(CENTER_ALIGNMENT);
		box1.add(Box.createVerticalStrut(60));
		box1.add(Box.createHorizontalStrut(20));
		box1.add(jbInCar);
		box1.add(Box.createVerticalStrut(10));
		box1.add(jbOutCar);
		box1.add(Box.createVerticalStrut(10));
		box1.add(jbMemList);
		box1.add(Box.createVerticalStrut(50));
		box1.add(btn_sales);
		box1.add(Box.createVerticalStrut(10));
		box1.add(btn_back);
		container1.add(box1);

		// 동쪽
		// 동쪽 상단 : 전체, 대기, 완료, 검색바
		JPanel container2Header = new JPanel(new BorderLayout(30,0));
		// 동쪽 상단 안쪽 컨테이너 생성 
		JPanel container2_1 = new JPanel();
		JPanel container2_2 = new JPanel();
		container2_1.add(jbAll); container2_1.add(jbStand); container2_1.add(jbFinish); // 전체, 대기, 완료 버튼
		container2_2.add(jlSearch); container2_2.add(searchbar); container2_2.add(jbSearch); // 검색바 부분
		container2Header.add(container2_1, BorderLayout.WEST);
		container2Header.add(container2_2, BorderLayout.EAST);
		
		// 동쪽 하단 : 회원 차량 조회, 비회원 차량 조회, 삭제
		JPanel container2Foot = new JPanel(new BorderLayout());
		// 동쪽 하단 안쪽 컨테이너 생성 
		JPanel container2_3 = new JPanel();
		JPanel container2_4 = new JPanel();
		container2_3.add(searchCarMem); container2_3.add(searchCarNotMem);  // 회원, 비회원 차량 조회
		container2_4.add(jbDelete);
		container2Foot.add(container2_3, BorderLayout.WEST);
		container2Foot.add(container2_4, BorderLayout.EAST);
		container2.add(container2Header, BorderLayout.NORTH);
		container2.add(jsp, BorderLayout.CENTER);
		container2.add(container2Foot, BorderLayout.SOUTH);
		
		getContentPane().add(container1, BorderLayout.WEST);
		getContentPane().add(container2, BorderLayout.EAST);
		
		// 크기 조절
		setBounds(620, 280, 650, 430);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		// -----------------------------------------이벤트 처리-----------------------------------------//
		// 전체 
		jbAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				select(); // 메서드 호출
			}
		});		
		
		// 대기 (현재 주차된 차량)
		jbStand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				selectStand(); // 메서드 호출
			}
		});
		
		// 완료 (출차된 차량)
		jbFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				selectFinish(); // 메서드 호출
			}
		});
		
		// 검색 버튼
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
				search(); // 메서드 호출
			}
		});
		
		// 입차 버튼
		jbInCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String car_num = JOptionPane.showInputDialog("입차하실 차량 번호를 입력해주세요");
				if (car_num == null) {
				}else {
					newInCar(car_num);
					model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
					select();
				}
				
			}
		});
		
		// 출차 버튼
		jbOutCar.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(null, "선택된 차량이 없습니다.");
				}else {
					outCar(); // 메서드 호출
					model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
					select();
				}
				
				
			}
		});
		
		// 회원 목록
		jbMemList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				new MList();
				dispose();
			}
		});
		
		//매출 조회
		btn_sales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Accounts();
				
			}
		});
		
		//이전으로
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn();
				dispose();
				
			}
		});
		
		// 회원 차량 조회
		searchCarMem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				searchCarMem(); // 메서드 호출
			}
		});
		
		// 비회원 차량 조회
		searchCarNotMem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con = DBConnection.getConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
				searchCarNotMem(); // 메서드 호출
			}
		});
		
		// 삭제 
		jbDelete.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(null, "선택된 차량이 없습니다.");
				}else {
					int result = JOptionPane.showConfirmDialog
							(null, "정말로 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "취소 하셨습니다.");
					}else if (result == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "취소 하셨습니다.");
					}else if (result == JOptionPane.YES_OPTION) {
						parkingDelete();
						model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드
						select(); // 메서드 호출
						
					}
				}
				
			}
		});
			
	}
	
	
	/***************************************메서드 시작 *************************************/
	// parking 테이블의 전체 목록을 조회하는 메서드
	void select() {
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from parking where not mem_y ='x' order by car_num";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_num = rs.getString("car_num");
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				int pTime = 0;
				int pCharge = 0;
				String mem_y = rs.getString("mem_y");
				if (mem_y.equalsIgnoreCase("y")) {
					mem_y="회원";
				}else {
					mem_y="비회원";
				}
				String out_ox = rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
					pCharge =  pTime * (charge/10);
					out_ox="출차";
				}else {
					out_ox="주차중";
					 pTime = (int)((now.getTime()-in_car.getTime())/(60*1000));
		             pCharge = pTime * (charge/10);
				}
				
				Object[] data = {car_num, in_car, out_car, pTime+" 분", charge+" 원", pCharge+" 원", mem_y, out_ox};
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
	
	// 현재 주차된 차량 조회 메서드
	void selectStand() {
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from parking where out_ox = 'x'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_num = rs.getString("car_num");
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				int pTime = 0;
				int pCharge = 0;
				String mem_y = rs.getString("mem_y");
				if (mem_y.equalsIgnoreCase("y")) {
					mem_y="회원";
				}else {
					mem_y="비회원";
				}
				String out_ox = rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
					pCharge =  pTime * (charge/10);
					out_ox="출차";
				}else {
					out_ox="주차중";
					 pTime = (int)((now.getTime()-in_car.getTime())/(60*1000));
		             pCharge = pTime * (charge/10);
				}

				Object[] data = {car_num, in_car, out_car, pTime+" 분", charge+" 원", pCharge+" 원", mem_y, out_ox};
				//레코드 모델에 추가
				model.addRow(data);
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			rs.close(); pstmt.close(); con.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // selectStand() 메서드 end
	
	// 출차된 차량 조회 메서드
	void selectFinish() {
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from parking where out_ox = 'o'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_num = rs.getString("car_num");
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				int pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
				int pCharge =  pTime * (charge/10);
				String mem_y = rs.getString("mem_y");
				if (mem_y.equalsIgnoreCase("y")) {
					mem_y="회원";
				}else {
					mem_y="비회원";
				}
				String out_ox = rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					out_ox="출차";
				}else {
					out_ox="주차중";
				}

				Object[] data = {car_num, in_car, out_car, pTime+" 분", charge+" 원", pCharge+" 원", mem_y, out_ox};
				//레코드 모델에 추가
				model.addRow(data);
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			rs.close(); pstmt.close(); con.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // selectFinish() 메서드 end
	
	// 차량 검색 메서드
	void search(){
		try {
			String car_num = searchbar.getText();
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from parking where car_num like '%"+car_num+"%'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				car_num = rs.getString("car_num");
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				int pTime = 0;
				int pCharge = 0;
				String mem_y = rs.getString("mem_y");
				if (mem_y.equalsIgnoreCase("y")) {
					mem_y="회원";
				}else {
					mem_y="비회원";
				}
				String out_ox = rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
					pCharge =  pTime * (charge/10);
					out_ox="출차";
				}else {
					out_ox="주차중";
					 pTime = (int)((now.getTime()-in_car.getTime())/(60*1000));
		             pCharge = pTime * (charge/10);
				}

				Object[] data = {car_num, in_car, out_car, pTime+" 분", charge+" 원", pCharge+" 원", mem_y, out_ox};
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
	
	// 목록에 있는 차량을 입차상태로 변경
	void inCar() {
		try {
			int row = table.getSelectedRow();
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			String car_num = (String)(model.getValueAt(row, 0));
			String out_ox =(String)(model.getValueAt(row, 7));
			if (out_ox.equalsIgnoreCase("주차중")) {
				JOptionPane.showMessageDialog(null, "이미 주차된 차량입니다.");
			}else {
				sql = "update parking set in_car = sysdate, out_car = in_car, out_ox = 'x' where car_num = '"+car_num+"'";
				
				// 2. 오라클 데이터베이스에 SQL문 전송 및 실행
				pstmt = con.prepareStatement(sql);
				int res = pstmt.executeUpdate();
				
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "입차상태로 변경했습니다.");
				}
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			pstmt.close(); //con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // inCar() 메서드 end
	
	void newInCar(String car_num) {
		try {
			sql = "select car_num, out_ox from parking where car_num = '"+car_num+"'";			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 입차하려는 차량이 데이터 베이스에 있는지 파악
			if (rs.next()) { 
				String out_ox =rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					String sql2 = "select car_num from p_member where car_num = '"+car_num+"'";
					pstmt = con.prepareStatement(sql2);
					rs = pstmt.executeQuery();
					// 입차하려는 차량이 회원목록에 있는지 파악
					if (rs.next()) { // 회원 목록에 있을 때
						String sql3 = "update parking set in_car = sysdate, out_car = sysdate, mem_y = 'y', out_ox = 'x' "
								+ "where car_num = '"+car_num+"'";
						pstmt = con.prepareStatement(sql3);
						int res = pstmt.executeUpdate();
						if (res > 0) {
							JOptionPane.showMessageDialog(null, "차량을 입차했습니다.");
						}
					}else { // 회원 목록에 없을 때
						String sql3 = "update parking set in_car = sysdate, out_car = sysdate, mem_y = 'n', out_ox = 'x' "
								+ "where car_num = '"+car_num+"'";
						pstmt = con.prepareStatement(sql3);
						int res = pstmt.executeUpdate();
						if (res > 0) {
							JOptionPane.showMessageDialog(null, "차량을 입차했습니다.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "현재 주차중인 차량입니다. 출차 후 다시 시도해주세요");
				}
				
			}else { // 데이터 베이스에 없을 때
				String sql2 = "insert into parking values('"+car_num+"', sysdate, sysdate, 500, 'n', 'x')";
				pstmt = con.prepareStatement(sql2);
				int res = pstmt.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "새로운 차량을 입차했습니다.");
				}
			}
			// 2. 오라클 데이터베이스에 SQL문 전송 및 실행
			
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			pstmt.close(); //con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // newInCar() 메서드 end
	
	// parking 출차 시간 업데이트   // 출차 할 때
	void outCar() {
		try {
			int row = table.getSelectedRow();
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			String car_num = (String)(model.getValueAt(row, 0));
			sql = "update parking set out_car = sysdate, out_ox = 'o' where car_num = '"+car_num+"'";
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 실행
			pstmt = con.prepareStatement(sql);
			int res = pstmt.executeUpdate();
			
			if (res > 0) {
				JOptionPane.showMessageDialog(null, "출차상태로 변경했습니다.");
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			pstmt.close(); //con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // OutCar 메서드 end
	
	
	// 회원 차량 조회
	void searchCarMem() {
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from parking where mem_y = 'y'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_num = rs.getString("car_num");
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				int pTime = 0;
				int pCharge = 0;
				String mem_y = rs.getString("mem_y");
				if (mem_y.equalsIgnoreCase("y")) {
					mem_y="회원";
				}else {
					mem_y="비회원";
				}
				String out_ox = rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
					pCharge =  pTime * (charge/10);
					out_ox="출차";
				}else {
					out_ox="주차중";
					 pTime = (int)((now.getTime()-in_car.getTime())/(60*1000));
		             pCharge = pTime * (charge/10);
				}

				Object[] data = {car_num, in_car, out_car, pTime+" 분", charge+" 원", pCharge+" 원", mem_y, out_ox};
				//레코드 모델에 추가
				model.addRow(data);
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			rs.close(); pstmt.close(); con.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 회원 차량 조회
	void searchCarNotMem() {
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			sql = "select * from parking where mem_y = 'n'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_num = rs.getString("car_num");
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				int pTime = 0;
				int pCharge = 0;
				String mem_y = rs.getString("mem_y");
				if (mem_y.equalsIgnoreCase("y")) {
					mem_y="회원";
				}else {
					mem_y="비회원";
				}
				String out_ox = rs.getString("out_ox");
				if (out_ox.equalsIgnoreCase("o")) {
					pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
					pCharge =  pTime * (charge/10);
					out_ox="출차";
				}else {
					out_ox="주차중";
					 pTime = (int)((now.getTime()-in_car.getTime())/(60*1000));
		             pCharge = pTime * (charge/10);
				}

				Object[] data = {car_num, in_car, out_car, pTime+" 분", charge+" 원", pCharge+" 원", mem_y, out_ox};
				//레코드 모델에 추가
				model.addRow(data);
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			rs.close(); pstmt.close(); con.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	// parking 테이블 행 삭제 
	void parkingDelete() {
		try {
			int row = table.getSelectedRow();
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성
			String car_num = (String)(model.getValueAt(row, 0));
			
			sql = "select car_num from p_member where car_num = '"+car_num+"'";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sql2 = "update parking set mem_y = 'x' where car_num = '"+car_num+"'";
				pstmt = con.prepareStatement(sql2);
				int res = pstmt.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "삭제했습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "다시 시도 해주세요");
				}
			}else {
				String sql2 = "delete from parking where car_num = '"+car_num+"'";
				pstmt = con.prepareStatement(sql2);
				int res = pstmt.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "삭제했습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "다시 시도 해주세요");
				}
			}
			
			// 3. 오라클 데이터베이스에 연결되어있던 자원 종료
			rs.close(); pstmt.close(); //con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // parkingDelete() 메서드 end
	
	
	
	// 주차시간을 계산하는 메서드 
	int pTime() {
		int pTime = 0;
		try {
			sql = "select * from parking";
			pstmt = con.prepareStatement(sql);
			
			Date in_car = rs.getDate("in_car");
			Date out_car = rs.getDate("out_car");
			
			pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pTime;
	}

	
	// 주차요금을 계산하는 메서드 
	int pCharge(int pTime) {
		int pCharge = 0; // 주차요금
		pTime = pTime();
		try {
			sql = "select * from parking";
			pstmt = con.prepareStatement(sql);
			
			pCharge = pTime * (charge/10);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pCharge;
	}
	
	


}
