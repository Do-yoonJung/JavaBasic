package inheritance;

import java.util.Scanner;

public class Ex05_Remote {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TV tv = new TV();
		Radio radio = new Radio();
		Computer computer = new Computer();
		
		while(true) {
			System.out.print("1. TV / 2. Radio / 3. Computer / 4. 종료 : ");
			
			int menu = sc.nextInt();
			
			if(menu == 4) {
				break;
			}
			
			System.out.print("1. 볼륨 Up / 2. 볼륨 Down : ");
			int volume = sc.nextInt();
			
			switch(menu) {
			case 1 :	//TV
				if(volume == 1) {
				tv.volumeUp();
				}else {
					tv.volumeDown();
				}
				break;
			case 2 :	//Radio
				if(volume == 1) {
					radio.volumeUp();
					}else {
						radio.volumeDown();
					}
					break;
			case 3 :	//Computer
				if(volume == 1) {
					computer.volumeUp();
					}else {
						computer.volumeDown();
					}
					break;
			}	//switch~case end
			System.out.println();
			
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::");
			
			System.out.println("TV Volume : " + tv.getVol() + " / Radio Volume : " + radio.getVol()
									+ " / Computer Volume : " + computer.getVol());
		}	//while end
		
		System.out.println();
		System.out.println("수고하셨습니다.");
		sc.close();
	}
}
