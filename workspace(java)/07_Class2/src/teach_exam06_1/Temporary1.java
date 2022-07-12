package teach_exam06_1;

public class Temporary1 extends Employee1 {
	
	private int time;
	private int pays;
	
	public Temporary1 () {}
	
	public Temporary1 (String name, int time, int pays) {
		this.name = name;
		this.time = time;
		this.pays = pays;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPays() {
		return pays;
	}

	public void setPays(int pays) {
		this.pays = pays;
	}

	@Override
	int getPay() {
		return time * pays;
	}

}
