package inheritance;

public class Employee extends Human{
	
	//String name;
	//int age;
	//String job;
	int salary;			//급여
	
	void employeeInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("직업: " + job);
		System.out.println("급여: " + salary);
	}
}
