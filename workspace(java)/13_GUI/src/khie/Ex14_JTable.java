package khie;

import javax.swing.*;

public class Ex14_JTable extends JFrame{

	public Ex14_JTable() {
		
		setTitle("JTable 예제");
		
		//JTable 컴포넌트는 컨테이너에 올리지 않고 바로 JTable에 올리면 됨
		String[] header = {"학생이름", "국어점수", "영어점수", "수학점수", "자바점수"};
		String[][] contents = {
				{"홍길동", "94", "88", "90", "90"},
				{"이순신", "90", "72", "90", "90"},
				{"유관순", "91", "71", "90", "90"},
				{"김유신", "88", "67", "90", "90"},
				{"김연아", "97", "98", "90", "90"},
				{"강감찬", "71", "70", "90", "90"},
				{"세종대왕", "100", "100", "90", "90"},
				{"백종원", "89", "88", "90", "90"},
				{"유재석", "94", "88", "90", "90"},
				{"강호동", "80", "88", "90", "90"},
		};
		
		JTable table = new JTable(contents, header);
		
		//1-1. 스크롤바를 만들어보자.
		JScrollPane jsp = new JScrollPane(
				table, 		//스크롤바가 보여질 컴포넌트
				//수직으로 스크롤바를 보여줄지 여부 확인
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				//수평으로 스크롤바를 보여줄지 여부 확인
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//2.컴포넌트를 프레임에 올려야한다.
		add(jsp);
		
		setBounds(200,200,300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex14_JTable();
		
	}

}
