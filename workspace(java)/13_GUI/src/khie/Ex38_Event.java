package khie;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex38_Event extends Frame implements MouseListener{
	
	CardLayout cardLayout = new CardLayout();
	
	JPanel container1 = new JPanel();
	JPanel container2 = new JPanel();
	JPanel container3 = new JPanel();
	JPanel container4 = new JPanel();
	
	public Ex38_Event() {

		setTitle("CardLayout 예제");
		setLayout(cardLayout);
		
		//각각 컨테이너에 배경색 지정
		container1.setBackground(Color.BLUE);
		container2.setBackground(Color.YELLOW);
		container3.setBackground(Color.CYAN);
		container4.setBackground(Color.GRAY);
		
		//1.컴포넌트
		//JLabel label1 = new JLabel("Card1");
		JLabel label2 = new JLabel("Card2");
		JLabel label3 = new JLabel("Card3");
		JLabel label4 = new JLabel("Card4");
		
		//2.컴포넌트를 컨테이너에
		//container1.add(label1);
		container1.add(new JLabel("Card1"));
		container2.add(label2);
		container3.add(label3);
		container4.add(label4);
		
		add(container1, "1");
		add(container2, "2");
		add(container3, "3");
		add(container4, "4");
		
		//컴포넌트와 이벤트 리스너와의 연결 작업
		container1.addMouseListener(this);
		container2.addMouseListener(this);
		container3.addMouseListener(this);
		container4.addMouseListener(this);
		
		setBounds(200,200,300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex38_Event();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//다음 카드로 넘어가는 메서드
		cardLayout.next(this);			//다음
		//cardLayout.previous(this);	//이전
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
