package khie;

/*
 * 3. 기타(보조 제어문)
 * 		break 명령어
 * 		현재의 제어문을 빠져 나가는 명령어
 * 		보통은 switch~case문과 반복문에서 사용됨
 * 		반복문에서는 if문 블럭을 제외한 첫번째 블럭에서 빠져나가는 명령어
 */

public class Ex33 {

	public static void main(String[] args) {

		for(int i=1; i<=100; i++) {
			if(i > 50) {	//51이 되었을 때
				break;
			}
			
			System.out.println("i: " + i);
		}
	}
}