package khie;

//Ex02 클래스에서 발생한 예외처리 코드를 이용하여 처리해주세요.

public class Ex05 {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		String str1 = "korea";
		
		String str2 = null; 		//null: 값이 없는 상태
		
		try {
			//length(): 현재 문자열의 길이를 정수값으로 알려주는 메서드
			System.out.println("str1 문자열의 길이: " + str1.length());
			System.out.println("str2 문자열의 길이: " + str2.length());
		}catch(Exception e) {
			System.out.println("예외가 발생했습니다.");
			System.out.println("예외 정보: " + e);
		}
		
		System.out.println("프로그램 종료");
		
	}
}
