package khie;

import java.awt.BorderLayout;

import javax.swing.*;

public class Ex25_Layout extends JFrame {
	
	Ex25_Layout(){
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
	}
	
	public static void main(String[] args) {
		new Ex25_Layout();
	}
}
