package abstracts;

public abstract class Person {	//추상 클래스
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//사람의 정보를 출력하는 메서드
	abstract void output();		//추상 메서드
	

}
