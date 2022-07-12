package model;

/*
 * ★★★★★★★★★★★★★★★★★★★★★★
 * 자바 빈(Java Bean)?
 * - DB에 접근하여 테이블의 특정 컬럼(속성)에 값을 저장하거나 저장된 값을 가져올 때 사용하는 클래스.
 * - Java Bean == DTO(Date Transfer Object) == VO(Value Object)
 * - 구성요소
 * 	 1. 멤버변수 - DB 컬럼명: 접근지정자(private)
 * 	 2. setter(): 지정자 메서드
 * 	 3. getter(): 획득자 메서드
 */

public class MemberDTO {
	
	//만약에 DB상의 테이블의 이름이 member(회원 테이블)이라고 가정했을 때 
	//member 테이블의 구성(컬럼) id, name, age, phone, address로
	//구성이 되어있다고 가정을 하면
	
	//멤버변수
	private String id;			//회원 아이디
	private String name;		//회원 이름
	private int age; 			//회원 나이
	private String phone;		//회원 연락처
	private String address; 	//회원 주소
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String name, int age, String phone, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
