package Class;

public class Ex04_Student {

	public static void main(String[] args) {

		//기본 생성자로 객체를 생성
		Student student = new Student();
		
		student.num = 2022001;
		student.name = "홍길동";
		student.major = "경제학과";
		student.addr = "서울시 남대문로";
		
		student.display();
		System.out.println();
		
		//인자 생성자로 객체를 생성
		Student student1 = new Student(2022002, "유관순", "회계학과", "충남 천안시");
		student1.display();
		
	}
}
