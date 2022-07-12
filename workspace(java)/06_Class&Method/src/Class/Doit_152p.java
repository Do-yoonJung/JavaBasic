package Class;

public class Doit_152p {
	
	int age;
	String name;
	boolean marriage;
	int children;
	
	public Doit_152p() { }
	
	public Doit_152p(int age, String name, boolean marriage, int children) {
		this.age = age;
		this.name = name;
		this.marriage = marriage;
		this.children = children;
	}
	
	public void print() {
		System.out.println("이 사람의 나이: " + age);
		System.out.println("이 사람의 이름: " + name);
		System.out.println("이 사람의 결혼 여부: " + marriage);
		System.out.println("이 사람의 자녀 수: " + children);
	}
	
	public static void main(String[] args) {
		Doit_152p person = new Doit_152p(40, "홍길동", true, 3);
		person.print();
	}
	
}
