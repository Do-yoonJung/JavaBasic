package exam06_1;

public class Permanent extends Employee{
	
	int pays;
	int bonus;
	
	Permanent(){}
	
	public Permanent(String name, int pays, int bonus) {
		this.name = name;
		this.pays = pays;
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getPays() {
		return pays;
	}

	public void setPays(int pays) {
		this.pays = pays;
	}

	@Override
	int getPay() {
		return pays + bonus;
	}
}
