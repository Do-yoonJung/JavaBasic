package khie;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 파일 복사
 * - Koala.jpg: 원본 이미지 파일
 * - Copied.jpg: 복사 이미지 파일
 */

public class Ex08 {

	public static void main(String[] args) throws Exception {

		//원본 이미지 파일
		FileInputStream fis = new FileInputStream("C:/test/Koala.jpg");
		
		//원본 이미지 파일이 복사되어 저장될 파일
		FileOutputStream fos = new FileOutputStream("C:/test/Copied.jpg");
		
		int readByte;
		
		while(true) {
			readByte = fis.read();
			
			if(readByte == -1) {
				break;
			}
			
			fos.write(readByte);
		}
		
		//입출력 객체 닫기
		fos.close();	fis.close();
		
		System.out.println("복사완료!");
		
	}

}
