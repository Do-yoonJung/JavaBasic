package teach_exam06_1;

public class Employee {		//부모클래스
	
	String name;			//이름

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//자식클래스에서 재정의를 진행할 원형 메서드.
	int getPay() {
		return 0;
	}
	
}
