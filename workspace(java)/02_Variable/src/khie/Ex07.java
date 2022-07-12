package khie;

public class Ex07 {
	public static void main(String[] args) {
		
		// 두 수를 서로 교환을 해보자
		int su1 = 47;
		int su2 = 81;
		
		System.out.println("변경 하기 전......");
		System.out.println("su1: " + su1 + " su2: " + su2);
		System.out.println();
		
		int temp = su1;
		su1 = su2;
		su2 = temp;
		System.out.println("변경 후......");
		System.out.println("su1: " + su1 + " su2: " + su2);
	}
}