package Class;

public class Doit_168p {
	
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Doit_168p(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean isValid() {
		
		if(month == 2) {
			if(day < 1 || day > 28) {
				return false;
			}else {
				return true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Doit_168p myDate = new Doit_168p(30, 2, 2000);
		System.out.println(myDate.isValid());
		
		Doit_168p myDate2 = new Doit_168p(2, 10, 2006);
		System.out.println(myDate2.isValid());
	}
	
}
