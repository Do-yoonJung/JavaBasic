package string;

/*
 * String 클래스의 단점
 * - 빈번하게 문자열 연산을 실행할 경우 메모리(heap)를 많이 차지하게 됨.
 * - 매번 연산 시마다 새로운 객체를 생성하게 됨.
 *   ==> 힙(heap) 영역의 과부하가 발생할 가능성이 많음
 * - 이러한 단점을 개선한 클래스가 등장을 함: StringBuffer 클래스
 */

public class Ex04 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("java ");
		
		//1. append(): 문자열을 추가해주는 메서드
		System.out.println("문자열 추가 후: " + sb.append("program"));
		System.out.println();
		
		//2. replace(): 문자열을 교체하는 메서드
		//	 형식) replace(시작 index, 끝(-1) index, "교체할 문자열")
		sb.replace(0, 4, "spring");
		
		System.out.println("문자열 교체 후: " + sb);
		System.out.println();
		
		//3. substring(): 문자열을 추출하는 메서드
		//	 형식1) substring(시작 index)
		//	 형식2) substring(시작 index, 끝(-1) index)
		StringBuffer sb2 = new StringBuffer("2022/02/09 15:28:30");
		System.out.println("오늘 날짜: " + sb2.substring(0, 10));
		System.out.println("현재 시간: " + sb2.substring(11));
	}

}
