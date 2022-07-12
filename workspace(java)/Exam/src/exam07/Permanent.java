package exam07;

public class Permanent extends Employee {
	
	int salary;
	int bonus;
	
	public Permanent() {}
	
	public Permanent(String name, int salary, int bonus) {
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	int getPays() {
		return salary + bonus;
	}

}
