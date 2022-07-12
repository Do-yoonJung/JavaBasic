package khie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex39_Event extends JFrame{

	public Ex39_Event() {

		setTitle("색상 예제");
		
		JMenuBar bar = new JMenuBar();
		
		JMenu menu = new JMenu("글자");
		
		JMenuItem item = new JMenuItem("글자색");
		
		//1.메뉴아이템을 메뉴에 올려주어야 한다.
		menu.add(item);
		
		//2.메뉴를 메뉴바에 올려주어야 한다.
		bar.add(menu);
		
		//프레임에 올리기
		setJMenuBar(bar);
		
		JPanel container = new JPanel(new BorderLayout());
		
		//1.컴포넌트
		JLabel label = new JLabel("방가방가");
		
		/*
		 * new Font("글자체", "효과", "글자 크기")
		 * - 글자체: 컴퓨터에 설치된 글자체 사용가능
		 * - 효과: - Font.BOLD: 진하게
		 *        - Font.ITALIC: 기울기
		 *        - Font.PLAIN: 보통
		 */
		
		label.setFont(new Font("맑은 고딕", Font.ITALIC, 25));
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		//2.컴포넌트를 컨테이너에 올려야한다.
		container.add(label);
		
		//3.컨테이너를 프레임에 올려야한다.
		add(container, BorderLayout.CENTER);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//4.이벤트 처리
		//"글자색"이라는 메뉴를 선택했을 때 이벤트 처리
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//이벤트를 발생시킨 객체(컴포넌트)의 문자열을 가져오는 메서드
				String command = e.getActionCommand();
				
				if(command.equals("글자색")) {
					//컬러 다디얼로그 출력하고 사용자가 선택한 색상을 알아오는 작업
					Color selectedColor = JColorChooser.showDialog
							(null, "Color", Color.yellow);
					
					if(selectedColor != null) {
						label.setForeground(selectedColor);
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex39_Event();
	}

}
