package khie;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

//3. Frame 클래스에 Listener를 구현하는 방법 - 가장 많이 사용.

public class Ex28_Event extends JFrame implements MouseListener{

	public Ex28_Event() {
		JPanel container = new JPanel();
		
		JButton exit = new JButton("종료");
		
		container.add(exit);
		add(container);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//B b = new B();
		
		exit.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new Ex28_Event();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
