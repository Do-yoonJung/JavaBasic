package Doit_Array;

import java.util.ArrayList;

public class StudentArrayList {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(1001, "James"));
		students.add(new Student(1002, "Tomas"));
		students.add(new Student(1003, "Edward"));
		
		System.out.println(students.size());
		System.out.println(students.remove(1));
		System.out.println(students.isEmpty());
		
		for(Student student : students) {
			student.showStudentInfo();
		}
	}
	
	
}
