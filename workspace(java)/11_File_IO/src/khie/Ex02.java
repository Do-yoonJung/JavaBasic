package khie;

import java.io.FileInputStream;
import java.io.InputStream;

public class Ex02 {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("C:/test/test2.txt");
		
		int readByte;
		
		byte[] bytes = new byte[3];
		
		String data = "";
		while(true) {
			readByte = is.read(bytes);
			if(readByte == -1) {
				break;
			}
			System.out.println(readByte);
			
			data += new String(bytes, 0, readByte);
		}
		System.out.println(data);
		
		is.close();
		
	}

}
