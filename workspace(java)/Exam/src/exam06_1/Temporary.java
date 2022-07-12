package exam06_1;

public class Temporary extends Employee{

	int pays;
	int time;
	
	public Temporary() {}

	public Temporary(String name, int pays, int time) {
		this.name = name;
		this.pays = pays;
		this.time = time;
	}
	
	public int getPays() {
		return pays;
	}

	public void setPays(int pays) {
		this.pays = pays;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	int getPay() {
		return pays * time;
	}
	
}
