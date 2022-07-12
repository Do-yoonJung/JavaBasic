package teach_exam06_1;

public class Temporary extends Employee{
	
	//멤버변수
	private int time;
	private int pays;
	
	public Temporary() {}		//기본생성자
	
	public Temporary(String name, int time, int pays) {
		this.name = name;
		this.time = time;
		this.pays = pays;
	}	//인자생성자
	
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
