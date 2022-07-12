package Doit_Array;

public class Student {
	public int studentId;
	public String name;
	
	public Student() {	}
	
	public Student(int id, String name) {
		this.studentId = id;
		this.name = name;
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showStudentInfo() {
		System.out.println(studentId + "," + name);
	}
}
