package exam03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		//학생 수, 이름, 국영수 점수, 총점,평균, 학점, 석차 배열 공간
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요: ");
		String[] name = new String[sc.nextInt()];
		int[] kor = new int[name.length];
		int[] eng = new int[name.length];
		int[] math = new int[name.length];
		int[] total = new int[name.length];
		double[] avg = new double[name.length];
		char[] grade = new char[name.length];
		int[] rank = new int[name.length];
		
		//값 입력 받기, 총점, 평균, 학점
		for(int i=0; i< name.length; i++) {
			System.out.print("이름 입력 : ");
			name[i] = sc.next();
			System.out.print("국어점수 입력 : ");
			kor[i] = sc.nextInt();
			System.out.print("영어점수 입력 : ");
			eng[i] = sc.nextInt();
			System.out.print("수학점수 입력 : ");
			math[i] = sc.nextInt();
			total[i] = kor[i] + eng[i] + math[i];
			avg[i] = total[i] / 3.0;
			
			if(avg[i]>=90) {
				grade[i] = 'A';
			}else if(avg[i]>=80) {
				grade[i] = 'B';
			}else if(avg[i]>=70) {
				grade[i] = 'C';
			}else if(avg[i]>=60) {
				grade[i] = 'D';
			}else {
				grade[i] = 'F';
			}
			
			//모든 학생은 1등
			rank[i] = 1;
		}

		//순위
		for(int i=0; i < total.length;i++) {
			for(int j=i+1; j < total.length; j++) {
				if(total[j]>total[i]) {
					rank[i]++;
				}
			}
		}
		
		//출력
		for(int i=0; i<name.length; i++) {
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.print("이름 : " + name[i] + "\t");
			System.out.print("총점 : " + total[i] + "점\t");
			System.out.printf("평균 : %.2f\t", avg[i]);
			System.out.print("학점 : " + grade[i] + "학점\t");
			System.out.print("순위 : " + rank[i] + "등\t\n");
		}
		
		sc.close();
	}
}
