package abstracts;

public class Professor extends Person {
	
	private String major;	//과목
	
	public Professor() {}
	
	public Professor(String name, String major) {
		this.name = name;
		this.major = major;
	}
	
	//추상 메서드 재정의한 메서드
	@Override
	void output() {
		System.out.println(getName() + " 교수입니다.");
		System.out.println(major + "를 전공합니다.");
	}

}
