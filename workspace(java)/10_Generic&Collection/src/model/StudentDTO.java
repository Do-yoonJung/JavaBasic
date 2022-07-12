package model;

public class StudentDTO {

	private String num;
	private String name;
	private String major;
	private String phone;
	private String address;
	
	public StudentDTO() {}
	public StudentDTO(String num, String name, String major, String phone, String address) {
		this.num = num;
		this.name = name;
		this.major = major;
		this.phone = phone;
		this.address = address;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
