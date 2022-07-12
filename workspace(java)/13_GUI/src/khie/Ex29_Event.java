package khie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//4. 익명 클래스를 이용하는 방법. - 많이 사용됨.

public class Ex29_Event extends JFrame{
	
	public Ex29_Event() {
		JPanel container = new JPanel();
		
		JButton exit = new JButton("종료");
		
		container.add(exit);
		add(container);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(exit, "시스템 종료");
				System.exit(0);
			}
		});
		
	}

	public static void main(String[] args) {
		new Ex29_Event();
	}

}
