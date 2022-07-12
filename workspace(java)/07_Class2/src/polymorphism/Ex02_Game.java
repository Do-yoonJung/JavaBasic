package polymorphism;

import java.util.Scanner;

public class Ex02_Game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		OverWatch watch = null;
		
		System.out.print("플레이 할 캐릭터 선택(1. 메이 / 2. 겐지 / 3. 멕크리) : ");
		
		int bunho = sc.nextInt();
		
		if(bunho == 1) {
			watch = new Mei();		//다형성
		}else if(bunho == 2) {
			watch = new Gengi();
		}else if(bunho == 3) {
			watch = new Mccree();
		}
		
		watch.name();
		watch.leftClick();
		watch.rightClick();
		watch.shiftButton();
		watch.eButton();
		watch.qButton();
		
		sc.close();
	}

}
