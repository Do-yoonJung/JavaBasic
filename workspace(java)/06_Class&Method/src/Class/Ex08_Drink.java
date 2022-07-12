package Class;

import java.util.Scanner;

public class Ex08_Drink {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자판기 음료 갯수를 입력하세요: ");
		
		//객체 배열 만들기
		Drink[] drinks = new Drink[sc.nextInt()];
		System.out.println("drinks : " + drinks);
		
		//Drink drink1 = new Drink("콜라", 2000);
		//Drink drink2 = new Drink("사이다", 2000);
		//Drink drink3 = new Drink("환타", 2000);
		//Drink drink4 = new Drink("캔커피", 1000);
		//Drink drink5 = new Drink("아침햇살", 3000);
		//Drink drink6 = new Drink("옥수수수염차", 1500);
		
		for(int i=0; i<drinks.length; i++) {
			System.out.println("음료의 이름과 가격을 입력하세요.....");
			System.out.println("::::::::::::::::::::::::::::::::::");
			drinks[i] = new Drink(sc.next(), sc.nextInt());
		}
		
		//System.out.println("drink[1]: " + drinks[1]);
		//System.out.println("drink[2]: " + drinks[2]);
		//System.out.println("drink[3]: " + drinks[3]);
		//System.out.println("drink[4]: " + drinks[4]);
		//System.out.println("drink[5]: " + drinks[5]);
		//System.out.println("drink[6]: " + drinks[6]);
		
		System.out.print("돈을 넣어주세요: ");
		int coin = sc.nextInt();
		
		//입력을 받은 coin과 객체 배열에 저장된 Drink클래스의 멤버변수인 price 가격을 비교해서 
		//coin보다 가격이 작거나 같은 음료를 선택
		for(int i=0; i<drinks.length; i++) {
			if(coin >= drinks[i].price) {
				System.out.print(drinks[i].name + "\t");
			}
		}
		sc.close();
	}
}
