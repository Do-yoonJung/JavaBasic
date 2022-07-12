package khie;

import java.util.Scanner;

// 키보드로 배열의 크기를 입력을 받아보자

public class Ex06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요: ");
		
		//int size = sc.nextInt();
		
		String[] str = new String[sc.nextInt()];
		
		System.out.println("str 배열의 크기: " + str.length);
		
		// 문자열 배열에 데이터를 저장
		for(int i=0; i < str.length; i++ ) {
			System.out.print((i+1)+ "번째 문자열 입력: ");
			
			str[i] = sc.next();
		}
		
		System.out.println();
		
		//문자열 배열에 저장된 데이터를 화면에 출력
		for(int i=0; i < str.length; i++) {
			System.out.println("str[" + i + "]: " + str[i]);
		}
		
		
		//문자열 배열에 저장된 문자열을 검색
		System.out.print("검색할 문자열을 입력하세요: ");
		
		String search = sc.next();
		
		for(int i=0; i<str.length; i++) {
			if(search.equals(str[i])) {
				System.out.println("찾은 문자열: " + str[i]);
				System.out.println("찾은 인덱스: str[" + i +"]");
			}
		}
		
		sc.close();
	}
}
