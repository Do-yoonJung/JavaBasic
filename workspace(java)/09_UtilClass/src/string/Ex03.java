package string;



public class Ex03 {

	public static void main(String[] args) {

		//1. 소문자 -> 대문자: toUpperCase()
		//   대문자 -> 소문자: toLowerCase()
		String str = "java program";
		
		System.out.println("대문자: " + str.toUpperCase());
		System.out.println("소문자: " + (str.toLowerCase()).toLowerCase());
		
		//2. 문자열의 길이를 정수값으로 반환해주는 메서드: length()
		System.out.println("str 문자열의 길이: " + str.length());
		System.out.println();
		
		//3. 문자열을 결합하는 메서드: concat()
		String str1 = "JAVA";
		String str2 = str1.concat(" PROGRAM");
		System.out.println("문자열 결합 결과: " + str2);
		System.out.println();
		
		//4. 대소문자를 구분하지 않는 메서드: equalsIgnoreCase()
		if(str.equalsIgnoreCase(str2)) {
			System.out.println("두 문자열은 같은 문자열이다.");
		}else {
			System.out.println("두 문자열은 다른 문자열이다.");
		}
		System.out.println();
		
		//5. 문자열에서 특정 단일 문자를 추출하는 메서드: charAt(index)
		String juminNo = "123456-2345678";
		
		char gender = juminNo.charAt(7);
		
		if(gender == '1' || gender == '3') {
			System.out.println("당신은 남자입니다.");
		}else if(gender == '2' || gender == '4') {
			System.out.println("당신은 여자입니다.");
		}else {
			System.out.println("당신은 외국인입니다.");
		}
	}

}
