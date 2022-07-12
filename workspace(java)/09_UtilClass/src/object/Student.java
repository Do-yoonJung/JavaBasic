package object;

/*
 * toString() 메서드 재정의
 * - Object 클래스에서 상속을 받은 메서드를 유용한 정보가 반환이 되도록 재정의
 * - 해당 클래스의 멤버변수가 정보를 가지고 있는데 가지고 있는 데이터에 올바른 값이 담겼는지,
 *   혹은 틀린 데이터가 담겼는지 확인하고 싶은 경우에 toString() 메서드를 재정의하여 값을 확인할 수 있음
 */

public class Student {

	String name;
	String hakbun;
	String major;
	String phone;
	
	public Student() {}
	public Student(String name, String hakbun, String major, String phone) {
		this.name = name;
		this.hakbun = hakbun;
		this.major = major;
		this.phone = phone;
	}
	
	//학생 정보를 출력하는 메서드
	//void getStudentInfo() {
	//	System.out.println("학생 이름: " + name);
	//	System.out.println("학생 학번: " + hakbun);
	//	System.out.println("학생 학과: " + major);
	//	System.out.println("학생 연락처: " + phone);
	//}
	
	@Override
	public String toString() {
		return "학생 이름: " + name + "\n학생 학번: " + hakbun + 
				"\n학생 학과: " + major + "\n학생 연락처: " + phone;
	}
}
