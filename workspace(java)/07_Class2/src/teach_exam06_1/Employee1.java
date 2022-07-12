package teach_exam06_1;

public abstract class Employee1 {	//추상클래스
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	abstract int getPay();		//추상메서드
	
}
