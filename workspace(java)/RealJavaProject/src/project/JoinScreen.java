package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class JoinScreen extends JFrame {

	Connection con = null;					//DB와 연결하는 객체
	PreparedStatement pstmt = null;			//SQL문을 DB에 전송하는 객
	ResultSet rs = null;					//SQL문 실행 결과를 가지고 있는 객체
	String sql = null;						//SQL문을 저장하는 문자열 변수
	
	JTextField jtf1, jtf2, jtf3;
	JPasswordField jpf1, jpf2;
	String id, pw1, pw2, name, phone;

	int click = 0;	//중복확인 성공했을때 저장할 변수
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					
					JoinScreen frame = new JoinScreen();
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
	public JoinScreen() {

		setTitle("회원 가입창");
		
		JLabel title = new JLabel("회원 가입");
		title.setBounds(140, 17, 138, 36);
		title.setFont(new Font("한컴 고딕", Font.BOLD, 30));
		
		JLabel jl1 = new JLabel("차량번호: ");
		jl1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtf1 = new JTextField(10);
		JButton jb1 = new JButton("중복확인");  // 차량 번호 중복확인
		jb1.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jb1.setBounds(250, 10, 97, 23);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(jl1); idPanel.add(jtf1);
		
		JLabel jl2 = new JLabel("비밀번호: ");  //유효한 비밀번호인지 확인????
		jl2.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jpf1 = new JPasswordField(10);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(jl2); pwPanel.add(jpf1);
		
		JLabel jl5 = new JLabel("비밀번호 확인: ");  //입력한 비밀번호 확인
		jl5.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jpf2 = new JPasswordField(10);
		
		JPanel pwcheckPanel = new JPanel();
		pwcheckPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwcheckPanel.add(jl5); pwcheckPanel.add(jpf2);
		
		JLabel jl3 = new JLabel("이  름: ");
		jl3.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtf2 = new JTextField(10);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(jl3); namePanel.add(jtf2);
		
		JLabel jl4 = new JLabel("연락처: ");
		jl4.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		jtf3 = new JTextField(10);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phonePanel.add(jl4); phonePanel.add(jtf3);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(35, 5, 215, 155);
		formPanel.setLayout(new GridLayout(5,1));
		formPanel.add(idPanel); formPanel.add(pwPanel);
		formPanel.add(pwcheckPanel); formPanel.add(namePanel);
		formPanel.add(phonePanel);

		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(10, 56, 408, 178);
		centerPanel.setLayout(null);
		centerPanel.add(formPanel);
		centerPanel.add(jb1);
		
		JButton cancel = new JButton("취소");
		cancel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		cancel.setBounds(139, 5, 61, 30);
		JButton OK = new JButton("확인");
		OK.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		OK.setBounds(200, 5, 61, 30);
		
		ButtonGroup BGroup = new ButtonGroup();
		BGroup.add(cancel); BGroup.add(OK);
		
		JPanel Bcontainer = new JPanel();
		Bcontainer.setBounds(0, 234, 396, 33);
		Bcontainer.setLayout(null);
		Bcontainer.add(cancel); Bcontainer.add(OK);
		getContentPane().setLayout(null);
		
		getContentPane().add(title);
		getContentPane().add(centerPanel);
		getContentPane().add(Bcontainer);
		
		setBounds(200,200,420,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//중복확인 이벤트
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				id = jtf1.getText();
				
				if(id.isEmpty()) { // 차량번호를 입력하지 않았을때 경고창 + 커서 깜빡
					JOptionPane.showMessageDialog(null, "차량번호를 입력해주세요.");
					jtf1.requestFocus();
				}else { // 차량 번호 중복 조회 메서드
					idMatch(id);
				}
			}
		});
		
		//취소 이벤트 
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FirstPage();
				dispose();
			}
		});
		
		//확인 이벤트
		//1. 빈칸있으면 경고
		//2. 비밀번호 일치하는지 확인
		//3. 중복확인 안했으면 중복확인하라고 경고
		//4. 입력한 정보 DB에 저장
		
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				pw1 = new String(jpf1.getPassword());
				pw2 = new String(jpf2.getPassword());
				name = jtf2.getText();
				phone = jtf3.getText();
				
				//1. 빈칸 경고
				if(pw1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					jpf1.requestFocus();
				}else if(pw2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
					jpf2.requestFocus();
				}else if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
					jtf2.requestFocus();
				}else if(phone.isEmpty()) {
					JOptionPane.showMessageDialog(null, "연락처를 입력해주세요.");
					jtf3.requestFocus();
				}
				
				//2. 비밀번호 일치 여부
				if(pw1.equals(pw2)) {
					//3. 중복확인 했는지
					if(click == 0) {
						JOptionPane.showMessageDialog(null, "차량번호 중복확인을 해주세요.");
					}else {
						//4. 입력한 정보 저장
						insert();
					}
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.\n다시 입력해주세요.");
					jpf1.setText(null); jpf2.setText(null);
					jpf1.requestFocus();
				}
			}
		});
	}
	
	//아이디 중복 확인 메서드
	void idMatch(String a) {
		
		try {
			con = DBConnection.getConnection();
			
			sql = "select car_num from p_member where car_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a);
			
			rs = pstmt.executeQuery();
			
			String car_num; 
			
			if(rs.next()) {
				car_num = rs.getString("car_num");
				JOptionPane.showMessageDialog(null, car_num + "는 이미 존재하는 차량입니다.");
				jtf1.setText(null);
				jtf1.requestFocus();
			}else {
				JOptionPane.showMessageDialog(null, "중복 확인 완료");
				click +=1;
			}
			
			pstmt.close(); rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//입력한 정보 저장하는 update메서드
	void insert(){
		
		try {
			con = DBConnection.getConnection();
			
			int res = 0;
			
			sql = "select car_num from parking where car_num = '"+id+"'";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { 
				String sql2 = "update parking set mem_y = 'y' where car_num = '"+id+"'";
				pstmt = con.prepareStatement(sql2);
				int res1 = pstmt.executeUpdate();
				
				if (res1 > 0) {
					String sql3 = "insert into p_member values('"+id+"', '"+name+"', '"+phone+"', "
							+ ""+0+", "+0+", '"+pw1+"')";
					pstmt = con.prepareStatement(sql3);
					res = pstmt.executeUpdate();
				}
				
			}else {
				String sql2 = "insert into parking values('"+id+"', sysdate, sysdate, 500, 'y', 'o')";
				pstmt = con.prepareStatement(sql2);
				int res1 = pstmt.executeUpdate();
				
				if (res1 > 0) {
					String sql3 = "insert into p_member values('"+id+"', '"+name+"', '"+phone+"', "
							+ ""+0+", "+0+", '"+pw1+"')";
					pstmt = con.prepareStatement(sql3);
					res = pstmt.executeUpdate();
				}

			}
			
			if(res > 0) {
				jtf1.setText(""); jtf2.setText(""); jtf3.setText("");
				jpf1.setText(""); jpf2.setText("");
				JOptionPane.showMessageDialog(null, "회원 가입 성공! 새로운 계정으로 로그인 해주세요");
				new LogIn();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "회원 가입 실패");
			}
			
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
