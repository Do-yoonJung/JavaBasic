package khie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 보조 스트림 관련 클래스
 * - 보조 스트림: 다른 스트림과 연결되어 여러가지 편리하느 기능을 제공해주는 스트림을 말함.
 * - 보조 스트림은 중간에 메모리 버퍼(bufferI와 작업을 함으로써 실행의 성능을 향상시킬 수 있음.
 *   예를든다면 프로그램은 직접 하드디슼크에 데이터를 보내지 않고 메모리 버퍼에 데이터를 보냄으로써
 *   쓰기 속도가 향상이됨. 버퍼는 데이터가 쌓이기만을 기다렸다가 버퍼가 꽉 차게 되면 데이터를 한꺼번에
 *   하드디스크로 보내줌으로써 출력 횟수를 줄여주게 됨.
 * - 스트림의 기능(속도)를 향상시키는 클래스.
 * - Bufferedxxx: 버퍼를 제공하는 보조 스트림 클래스.
 * - 버퍼(buffer): CPU와 IO간의 속도 차이를 보완.
 */

public class Ex06 {

	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("한 줄 문자열을 입력하세요.....");
		
		//readLine(): 보조스트림에서 제공하는 한 줄을 입력받는 메서드.
		br.readLine();
		String str = br.readLine();
		
		System.out.println("입력받은 문자열: " + str);
		
		//입출력 객체는 닫아주자.
		br.close();
		isr.close();
		
	}

}
