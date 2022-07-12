package exam07;

public abstract class Employee {

	String name;

	public Employee() {	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	abstract int getPays();
}
