package teach_exam06_1;

public class Permanent1 extends Employee1 {
	
	private int salary;
	private int bonus;
	
	public Permanent1 () {}
	
	public Permanent1 (String name, int salary, int bonus) {
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

	//추상메서드를 재정의
	@Override
	int getPay() {
		return salary + bonus;
	}

}
