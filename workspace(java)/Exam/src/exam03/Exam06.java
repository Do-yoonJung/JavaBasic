package exam03;

public class Exam06 {
	public static void main(String[] args) {
		
		//1. 다차원 배열의 가변 배열 선언 및 메모리 생성
		int[][] arr = new int[5][];		//	행: 4행, 열: 미지정
		
		//2. 가변 배열의 열 메모리 생성
		for(int i=0; i<5; i++) {
			arr[i] = new int[i+1];
		}
		
		//3. 가변 배열에 초기값 할당
		int count = 1;
		for(int i=0; i<arr.length; i++)	{
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = count;
				System.out.print(arr[i][j] + "\t");
				count ++;
			}
			System.out.println();
		}
	}
}
