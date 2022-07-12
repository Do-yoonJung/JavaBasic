package khie;

public class Ex21 {

	public static void main(String[] args) {
		
		//A~Z까지 문자 출력
		char alpha = 'A';
		
		while(alpha <= 'Z') {
			System.out.print(alpha);
			alpha++;
		}
		System.out.println();
		
		//Z~A 거꾸로 문자 출력
		char ap = 'Z';
		
		while(ap >= 'A') {
			System.out.print(ap);
			ap--;
		}
	}
}