package khie;

import java.io.IOException;

public class Ex03 {
	public static void main(String[] args) {
		
		System.out.println("한 줄을 입력하세요.....");
		int num;
		
		try {
			while(true) {
				num = System.in.read();
				if(num == '\n') {	//엔터치면
					break;
				}
				System.out.print((char)num);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		
}

