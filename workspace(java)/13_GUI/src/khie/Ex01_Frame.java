package khie;

import java.awt.Frame;

/*
 * java GUI(Graphic User Interface)
 * - 이미지 혹은 그래픽을 이용하여 메뉴들을 포함하는 화면을 구성하고, 
 *   키보드와 마우스 등의 편리한 입력 도구를 이용하여 사용자가 입력하기 편하도록 만들어진 사용자 인터페이스임.
 * - java에서는 AWT와 Swing으로 어떠한 언어보다 강력한 GUI 라이브러리를 제공하여 소프트웨어 개발자들이
 *   다양한 GUI를 쉽게 구성할 수 있도록 해주고 있음.
 * 
 * AWT와 Swing
 * - 자바언어는 GUI 프로그램을 쉽게 작성할 수 있도록 다양한 GUI 컴포넌트들을 제공함
 *   자바 컴포넌트는 AWT 컴포넌트와 Swing 컴포넌트로 구분이 됨.
 *   
 * 1. AWT 컴포넌트: - java.awt 패키지를 통하여 제공이 됨.
 *                - 운영체제의 도움을 받아 화면에 출력되기 때문에 운영체제의 자원을 많이 소모하여
 *                  운영체제의 자원을 많이 소모하여 운영체제에 많은 부담을 주게 됨.
 *                - 운영체제마다 컴포넌트의 모양이 다르게 나타남.
 * 2. Swing 컴포넌트: - javax.swing 패키지를 통하여 제공이 됨.
 *                  - AWT와 다르게 자바 언어로 작성이 되었음
 *                    ==> SUN사와 네스케이프라는 회사가 공동으로 개발함
 *                  - 운영체제의 도움을 받지 않았음 ==> 경량 컴포넌트라고 불림
 *                  - 운영체제와 관계 없이 항상 동일한 모양이 나타남
 *                  - AWT에는 없는 풍부한 고급 Swing 컴포넌트들을 추가적으로 개발하였음
 *                  - 다양하고 모양이 예쁜 Swing 컴포넌트를 더 많이 사용함
 *                    ==> 최근에는 거의 모든 GUI 프로그램이 Swing 기반으로 작성이 됨
 * 
 * GUI에서 알아두어야 할 용어 - 3가지
 * 1. 컴포넌트: 버튼, 텍스트상자, 레이블 상자, 옵션박스, 체크박스, 라디오버튼 등을 말함
 * 2. 컨테이너: 컴포넌트들을 담을 수 있는 클래스
 *            ==> 컴포넌트는 반드시 컨테이너에 올려져야 화면에 보여짐
 * 3. 프레임: 컨테이너들을 담을 수 있는 클래스
 *           ==> 컨테이너는 반드시 프레임에 올려져야 화면에 보여짐
 *           
 * Frame을 만드는 방법 - 첫번째 방법
 * 1. Frame이라는 클래스를 상속을 받아서 기본생성자를 통하여 Frame을 보여주는 방법
 */

public class Ex01_Frame extends Frame{
	
	public Ex01_Frame() {
		
		//프레임에 제목을 설정하는 방법
		super("첫번째 예제");
		
		//프레임의 위치를 설정하는 방법
		setLocation(100, 100);
		
		//프레임의 크기를 설정하는 방법
		setSize(300, 300);
		
		//프레임을 화면에 보여주어야함
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Ex01_Frame();

	}

}
