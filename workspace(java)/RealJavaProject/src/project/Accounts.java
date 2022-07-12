package project;

import java.awt.Font;
import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Accounts extends JFrame {
	Connection con = null;          // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체 
	ResultSet rs = null;            // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;              // SQL문을 저장하는 문자열 변수
	
	int charge = 500;   // 기본요금
	
	DefaultTableModel model;
	JTable table;
	JTextField searchbar;
		
	Scanner sc = new Scanner(System.in);
	
	final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
	static Calendar date = Calendar.getInstance();
	
	public Accounts() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("매출 조회");
		
		JPanel container0 = new JPanel();
		JPanel container1 = new JPanel(); // 상단 컨테이너
		JPanel container2 = new JPanel(); // 하단 컨테이너
		JPanel container3 = new JPanel(); // 하단 컨테이너
		
		
		JLabel jlDate = new JLabel(toStringDate(date) + DAY_OF_WEEK[date.get(Calendar.DAY_OF_WEEK)]+"요일");
		jlDate.setBounds(66, 29, 222, 26);
		jlDate.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		
		JLabel jlRecharge = new JLabel("충전금액 총액 : ");
		jlRecharge.setBounds(47, 11, 101, 20);
		jlRecharge.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JTextField jtfRecharge = new JTextField(10);
		jtfRecharge.setBounds(153, 5, 152, 32);
		jtfRecharge.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		String sumRecharge = " "+sumRecharge()+" 원";
		jtfRecharge.setText(sumRecharge);
		
		JLabel jlPCharge = new JLabel("주차요금 총액 : ");
		jlPCharge.setBounds(47, 11, 101, 20);
		jlPCharge.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JTextField jtfPCharge = new JTextField(10);
		jtfPCharge.setBounds(153, 5, 152, 32);
		jtfPCharge.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		//String sumPCharge = " "+sumPCharge()+" 원";
		//jtfPCharge.setText(sumPCharge);
		String sumDayPCharge = " "+sumDayPCharge()+" 원"; // 오늘 출차된 차량 기준 요금 주차요금 계산
		jtfPCharge.setText(sumDayPCharge);
		
		JLabel jlSale = new JLabel("현재 매출총액 : ");
		jlSale.setBounds(47, 11, 101, 20);
		jlSale.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		JTextField jtfSale = new JTextField(10);
		jtfSale.setBounds(153, 5, 152, 32);
		jtfSale.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		
		String tSale = " "+(sumPCharge()+sumRecharge()) +" 원";
		jtfSale.setText(tSale);
		
		JPanel container1_1 = new JPanel(); 
		JPanel container1_2 = new JPanel(); 
		getContentPane().setLayout(null);
		container0.setLayout(null);
		
		container0.add(jlDate);
		container1.setLayout(null);
		container1.add(jlRecharge); container1.add(jtfRecharge); 
		container2.setLayout(null);
		container2.add(jlPCharge); container2.add(jtfPCharge);		
		container3.setLayout(null);
		container3.add(jlSale); container3.add(jtfSale);
		
		Box box1 = Box.createVerticalBox();
		box1.setBounds(0, 0, 353, 313);
		box1.add(container0);
		box1.add(container1);
		box1.add(container2);
		box1.add(container3);
		
		getContentPane().add(box1);
		
		
		setBounds(200, 200, 367, 350);
		//pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	// 주차요금 계산 -- 비회원 ----------------오늘 날짜 기준 출차된 차량 주차요금 총액 계산!!
	int sumDayPCharge() {
		int pTime = 0;
		int pCharge = 0;
		int sumPCharge = 0; 
		try {
			con = DBConnection.getConnection();	
			String oYear = ((Object)date.get(Calendar.YEAR)).toString();
			String year = oYear.substring(2, 4);
			String month = ((Object)(date.get(Calendar.MONTH)+1)).toString();
			String day = ((Object)(date.get(Calendar.DATE))).toString();
			sql = "select * from parking where mem_y='n' and out_ox='o' and out_car>'"+year+"/"+month+"/"+day+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
				pCharge = pTime * (charge/10);
				sumPCharge += pCharge; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sumPCharge;
	}
	
	// 주차요금 계산 -- 비회원 
	int sumPCharge() {
		int pTime = 0;
		int pCharge = 0;
		int sumPCharge = 0; 
		try {
			con = DBConnection.getConnection();	
			sql = "select * from parking where out_ox='o' and mem_y='n' ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Date in_car = rs.getDate("in_car");
				Date out_car = rs.getDate("out_car");
				pTime = (int)((out_car.getTime()-in_car.getTime())/(60*1000));
				pCharge = pTime * (charge/10);
				sumPCharge += pCharge; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sumPCharge;
	}
	
	
	// 충전액 계산 -- 회원
	int sumRecharge() {
		int recharge = 0;
		int sumRecharge = 0; 
		try {
			con = DBConnection.getConnection();
			sql = "select * from p_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				recharge = rs.getInt("recharge");
				sumRecharge += recharge; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sumRecharge;
	}
	
	// 오늘 날짜 메서드 
	public static String toStringDate(Calendar date) {
		return date.get(Calendar.YEAR)+"년 " + (date.get(Calendar.MONTH)+1) +"월 " + date.get(Calendar.DATE) + "일 ";
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			Font f1 = new Font("한컴 고딕", Font.PLAIN, 15);
			UIManager.put("OptionPane.messageFont", f1);
			UIManager.put("OptionPane.buttonFont", f1);
			Accounts accounts = new Accounts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
