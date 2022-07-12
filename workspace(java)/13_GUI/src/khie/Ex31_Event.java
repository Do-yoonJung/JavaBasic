package khie;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Ex31_Event extends JFrame {

	public Ex31_Event() {
		
		setTitle("글자 이동 이벤트");
		
		//1.컴포넌트
		JPanel container = new JPanel();
		JLabel label = new JLabel("JAVA");
		
		//2.컴포넌트를 컨테이너에
		container.add(label);
		
		//3.컨테이너를 프레임에 
		add(container);
		
		setBounds(200,200,1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//4.이벤트 처리
		//container에서 특정 영역에 마우스를 클릭시 이벤트 진행
		container.addMouseListener(new MouseListener() {
			
			//눌려진 마우스 버튼이 떼어질 때
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//마우스 버튼이 눌려질 때
			@Override
			public void mousePressed(MouseEvent e) {

				int x = e.getX(); 	//마우스 버튼이 눌려질 때의 x 좌표값
				int y = e.getY();	//마우스 버튼이 눌려질 때의 y 좌표값
				//라벨 컴포넌트의 위치를 (x,y)로 이동
				label.setLocation(x, y);
			}
			
			//컴포넌트 위에 올라가 있던 마우스가 해당 컴포넌트를 떠날 때
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//컴포넌트 위에 마우스가 올라왔을 때
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//마우스 버튼이 클릭되었을 때.
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex31_Event();
	}

}
