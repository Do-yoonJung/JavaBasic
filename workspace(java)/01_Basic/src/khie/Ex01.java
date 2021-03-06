package khie;

// java에서의 한 줄 주석문

/*
 * java에서 두 줄 이상의 주석문
 * 내용: java 기초
 * 작성자: 정도윤
 * 작성일자: 2022.01.21
 */

/*
 * java 프로그램 작성 방법
 * 1. 클래스 단위로 프로그램을 작성한다.
 * 	  ==> 클래스 이름 작성 시 첫 글자는 대문자로 작성한다.
 * 2. 하나의 문장은 세미콜론(;)으로 끝난다.
 * 3. 클래스의 이름은 첫글자를 대문자로 시작을 하고,(Ex01)
 * 	  메서드의 이름은 첫글자를 소문자로 작성을 한다.(main)
 *    **객체: 이 세상에 존재하는 모든 사물
 *  	   자동차(객체)
 *  		* 속성(명사): 엔진, 핸들, 문, 네비게이션(객체를 대표하는 특징)
 *  		* 기능(동사): 달린다, 멈춘다(메서드가 이런 기능 괄호가 들어가는 거 무조건)
 *  4. main() 메서드 : 프로그램의 시작 위치를 의미한다. 가장 먼저 실행됨.
 *  				 ==>JVM이 main() 메서드를 찾아서 메서드 안의 내용을 순차적으로 실행을 함.
 */

/*
 * java소스 코드의 실행 과정(4단계)
 * 1. java 소스 파일(.java) 작성
 * 2. 소스파일(.java)을 작성한 후 컴파일을 수행하면 자바 가상 머신에서 동작하는 바이트 코드(.class)가 생성이 됨.
 * 	  이클립스 사용 시에는 소스 코드의 저장만으로도 캄파일이 자동으로 수행이 됨.
 * 	  소스 파일과 바이트 코드는 각각의 프로젝트 내의 src폴더와 bin 폴더 안에 위치함
 * 3. 바이트 코드(.class)를 실행하면 자바 가상 머신(JVM)은 운영체제에서 메모리를 할당을 받음.
 * 4. 자바 가상 머신이 main() 메서드를 실행을 함.
 */
public class Ex01 {	// { ==> Ex01클래스의 시작을 의미함.
	
	/*
	 * main() 메서드 - 기능
	 * 프로그램의 시작 위치를 의미함. 가장 먼저 실행이 되는 놈이다.
	 */
	
	public static void main(String[] args) {	// { ==> main() 메서드의 시작을 의미함.
		System.out.print("자바에 오신 여러분을 환영합니다!!!");
		System.out.println("...");
		
		/*
		 * System.out: 자바에서의 표준출력장치를 의미함.
		 * 			   표준출력장치(모니터, 콘솔)
		 * println(): 지정된 장치에 결과("" 안의 내용)을 출력하는 메서드.
		 * 			  ==> ln: line(출력을 한 후에 줄바꿈을 하라는 명령어)
		 * print(): 내용을 출력한 후에 다음 줄로 이동하지 않고 다음에 내용을 옆(오른쪽)에 출력하는 메서드.
		 * 
		 * 이클립스 프로그램 사용 시 단축 키
		 * 저장: ctrl + s(현재 소스 파일만), ctrl+shift+s(전체)
		 * 실행: ctrl + f11
		 * 출력문: syso + ctrl + space bar
		 */
	}	// { ==> main() 메서드의 끝을 의미함.
}	// { ==> Ex01클래스의 끝을 의미함.












