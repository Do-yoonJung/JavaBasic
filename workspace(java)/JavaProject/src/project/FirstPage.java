package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FirstPage extends JFrame {
	
	private JButton jb1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//테마 설정
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setTitle("주차 관리 시스템");
		
		JPanel container1 = new JPanel();
		container1.setBounds(0, 22, 286, 49);
		JPanel container2 = new JPanel();
		container2.setBounds(0, 94, 286, 221);

		//container1
		JLabel jl1 = new JLabel("주차 정산 시스템");
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		jl1.setFont(new Font("한컴 고딕", Font.BOLD, 30));
		
		//container2
		jb1 = new JButton("출차");
		jb1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb1.setBounds(95, 0, 100, 50);
		JButton jb2 = new JButton("회원가입");
		jb2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb2.setBounds(95, 60, 100, 50);
		JButton jb3 = new JButton("로그인");
		jb3.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		jb3.setBounds(95, 120, 100, 50);

		ButtonGroup BGroup = new ButtonGroup();
		BGroup.add(jb1); BGroup.add(jb2); BGroup.add(jb3);
		
		container1.add(jl1);
		container2.setLayout(null);
		
		container2.add(jb1); container2.add(jb2); container2.add(jb3);
		getContentPane().setLayout(null);
		
		getContentPane().add(container1);
		getContentPane().add(container2);
		
		setBounds(200,200,300,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//jb1 출차 이벤트 -> 회원 비회원 선택
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//차번호로 회원가입 여부 확인 -> 계산
				new Out();
				dispose();
			}
		});
		
		//jb2 회원가입 이벤트
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinScreen();
				dispose();
			}
		});
		
		//jb3 회원 메뉴 -> 로그인창 
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn();
				dispose();
			}
		});
	}
}
