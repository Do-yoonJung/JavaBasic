package khie;

public class Ex14 {

	public static void main(String[] args) {
		
		//주사위를 굴려서 임의의 숫자를 받아서 처리해보시오.
		int num = (int)(Math.random() * 6) + 1;	//Math는 double 타입이라 형변환을 해야함
		
		if(num == 1) {
			System.out.println("주사위 1번이 나왔습니다.");
		}else if(num == 2) {
			System.out.println("주사위 2번이 나왔습니다.");
		}else if(num == 3) {
			System.out.println("주사위 3번이 나왔습니다.");
		}else if(num == 4) {
			System.out.println("주사위 4번이 나왔습니다.");
		}else if(num == 5) {
			System.out.println("주사위 5번이 나왔습니다.");
		}else {
			System.out.println("주사위 6번이 나왔습니다.");
		}
		
	}
}