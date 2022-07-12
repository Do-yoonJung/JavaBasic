package khie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

//2.Adapter 클래스를 구현하는 법
class B extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(null, "시스템 종료");
		System.exit(0);
	}

}

public class Ex27_Event extends JFrame{

	public Ex27_Event() {

		JPanel container = new JPanel();
		
		JButton exit = new JButton("종료");
		
		container.add(exit);
		add(container);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		B b = new B();
		exit.addMouseListener(b);
	}
	
}
