package khie;

//1~100까지의 합을 구하는데 합이 200이 되는 순간까지만 합을 구하여 화면에 출력

public class Ex34 {

	public static void main(String[] args) {

		int sum = 0, i;
		for(i=1; i<=100; i++) { //지역변수: 여기에서 밖에 못 쓰는 변수
			sum += i;
			if(sum >= 200) {
				break;
			}
		}
		
		System.out.println("합: " + sum);
		System.out.println("마지막 숫자: " + i);
	}
}