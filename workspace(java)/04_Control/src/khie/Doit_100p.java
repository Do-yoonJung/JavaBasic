package khie;

import javax.swing.JOptionPane;

public class Doit_100p {
	public static void main(String[] args) {
		
		int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
		
		char grade = 0;
		
		if(score >= 90) {
			grade = 'A';
		}else if(score >= 80) {
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else if(score >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.println("학점: " + grade);
	}
}
