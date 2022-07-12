package khie;

import java.io.InputStreamReader;

/*
 * java 스트림의 종류
 * 1. 바이트 스트림 관련 클래스
 *    - 바이트 스트림 방식으로 데이터를 입출력하는 클래스.
 *    ==> xxxInputStream / xxxOutputStream
 * 2. 문자 스트림 관련 클래스
 *    - 문자 스트림 방식으로 데이터를 입출력하는 클래스.
 *    ==> xxxReader(입력) / xxxWriter(출력)
 * 3. 바이트 스트림 - 문자 스트림으로 변환 관련 클래스
 *    ==> InputStreamReader / OutputStreamWriter
 */

public class Ex04 {

	public static void main(String[] args) {
		
		System.out.println("입력 후 끝이라고 입력하세요.....");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		int readByte;
		
		try {
			while(true) {
				readByte = isr.read();
				if(readByte == '끝') {
					break;
				}
				System.out.print(readByte);
				System.out.print((char)readByte);
			}
			//입출력 스트림은 닫아주는 것이 좋다
			isr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
