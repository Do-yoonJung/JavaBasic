package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex36_Event extends JFrame{

	public Ex36_Event() {
		
		setTitle("커피 자판기");
		
		//컨테이너 4개
		JPanel container1 = new JPanel();	//north-1
		JPanel container2 = new JPanel();	//north-2
		JPanel container3 = new JPanel();	//north-3
		JPanel container4 = new JPanel();	//south 컨테이너
		
		//1.컴포넌트
		//1-1. north1
		JLabel title = new JLabel("원하는 커피 선택");
		
		//1-2. north2
		JRadioButton button1 = new JRadioButton("아메리카노(2500)");
		JRadioButton button2 = new JRadioButton("카페모카(3500)");
		JRadioButton button3 = new JRadioButton("에스프레소(2500)");
		JRadioButton button4 = new JRadioButton("카페라떼(4000)");
		
		
		ButtonGroup BGroup = new ButtonGroup();
		BGroup.add(button1);
		BGroup.add(button2);
		BGroup.add(button3);
		BGroup.add(button4);
		
		//1-3. north3
		JLabel label1 = new JLabel("수량: ");
		JTextField amount = new JTextField(5);
		JLabel label2 = new JLabel("입금액: ");
		JTextField money = new JTextField(10);
		
		//1-4. 가운데
		JTextArea blank = new JTextArea(5,20);
		JScrollPane jsp = new JScrollPane(
				blank,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		blank.setLineWrap(true);
		
		//1-5. south
		JButton result = new JButton("계산");
		JButton exit = new JButton("종료");
		JButton cancel = new JButton("취소");
		JButton window = new JButton("새창");
		
		//컨테이너에 컴포넌트 올리기
		container1.add(title);
		
		container2.add(button1);
		container2.add(button2);
		container2.add(button3);
		container2.add(button4);
		
		container3.add(label1);
		container3.add(amount);
		container3.add(label2);
		container3.add(money);
		
		container4.add(result);
		container4.add(exit);
		container4.add(cancel);
		container4.add(window);
		
		//새로운 컨테이너 두개
		JPanel group1 = new JPanel(new BorderLayout());
		JPanel group2 = new JPanel(new BorderLayout());
		
		//group1에 container1,2
		group1.add(container1, BorderLayout.NORTH);
		group1.add(container2, BorderLayout.CENTER);
		
		//group2에 container3, jsp, 4
		group2.add(container3, BorderLayout.NORTH);
		group2.add(jsp, BorderLayout.CENTER);
		group2.add(container4, BorderLayout.SOUTH);
		
		//컨테이너를 프레임에 올리기
		add(group1,BorderLayout.NORTH);
		add(group2,BorderLayout.CENTER);
		
		setBounds(200,200,300,300);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//4.이벤트 처리
		//계산 이벤트
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String coffeeStr = "";	//커피 종류 반환
				int coffeePrice = 0;
				
				if(button1.isSelected()) {
					coffeeStr = "아메리카노";
					coffeePrice = 2500;
				}else if(button2.isSelected()) {
					coffeeStr = "카페모카";
					coffeePrice = 3500;
				}else if(button3.isSelected()) {
					coffeeStr = "에스프레소";
					coffeePrice = 2500;
				}else if(button4.isSelected()) {
					coffeeStr = "카페라떼";
					coffeePrice = 4000;
				}
				
				int a = Integer.parseInt(amount.getText());
				int m = Integer.parseInt(money.getText());
				
				//공급가액: 수량*단가
				int sum = a * coffeePrice;
				
				//부가세액: 공급가액 * 0.1
				int vat = (int)(sum * 0.1);
				
				//총금액: 공급가액 + 부가세액
				int total = sum + vat;
				
				//잔액: 입금액 - 총금액
				int change = m - total;
				
				blank.append("커피종류: " + coffeeStr + "\n");
				blank.append("커피단가: " + coffeePrice + "원\n");
				blank.append("수량: " + a + "\n");
				blank.append("공급가액: " + sum + "원\n");
				blank.append("부가세액: " + vat + "원\n");
				blank.append("총금액: " + total + "원\n");
				blank.append("입금액: " + m + "원\n");
				blank.append("거스름돈: " + change + "원\n");
				
				amount.setText(null);
				money.setText(null);
				BGroup.clearSelection();
				
			}
		});
		
		//종료 이벤트
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//취소 이벤트
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				amount.setText(null);
				money.setText(null);
				blank.setText(null);
				BGroup.clearSelection();
				
			}
		});
		
		//새창(window) 버튼 이벤트
		window.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new Ex15_JTabbedPane();
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex36_Event();
	}
}
