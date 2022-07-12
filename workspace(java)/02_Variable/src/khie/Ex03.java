package khie;

public class Ex03 {
	public static void main(String[] args) {
		
		// 변수 선언 및 변수 초기화
		byte by = 127;
		System.out.println("by >>> " + by);
		
		// 자료형의 형변환(묵시적 형변환)
		int su1 = by;
		System.out.println("su1 >>> " + su1);
		
		int su2 = 150;
		System.out.println("su2 >>> " + su2);
		
		// 자료형의 형변환 필요(캐스팅) => 자료의 손실이 발생 할 수 있음
		byte by2 = (byte)su2; // 명시적 형변환
		
		/*
		 * by2 변수의 값이 -106이 나오는 이유
		 * 	byte 자료형의 범위(-128 ~ 127)를 벗어났기 때문에
		 * 	쓰레기 값이 나오게 되었음.
		 */
		System.out.println("by2 >>> " + by2);
		
		/*
		 * 형변환(casting): 해당 데이터 값의 자료형을 다른 타입의 자료형으로 변환하는 것
		 *  + 형변환은 boolean형을 제외한 7가지 자료형은 서로 형변환이 가능함.
		 * 
		 * 1. 묵시적 형변환
		 * 		==> 자료형의 크기가 작은 데이터를 큰 자료형의 데이터에 저장.
		 * 			이 때는 형변화 작업을 안 해도 된다.
		 * 2. 명시적 형변환
		 * 		==> 자료형의 크기가 큰 데이터를 작은 자료형의 데이터에 저장.
		 * 			이 때는 반드시 형변환 작업을 해야 한다.
		 * 			형변환 시 자료의 손실이 발생할 수 있음.
		 */
		
		
	}
}