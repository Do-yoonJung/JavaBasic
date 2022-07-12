package singleton;

/*
 * 싱글턴 방식(singleton)?
 * - 생성자를 private 접근지정자를 이용하여 외부에서 직접 접근을 못하게 불허하는 방식
 * - 외부에서 해당 인스턴스를 new로 생성하지 못하도록 하는 방식
 * - 사용하는 이유: 매번 객체를 생성하게 되면 메모리의 성능이 느려지는 단점이 발생하기 때문임
 */

public class Company {

	private static Company instance = null;
	
	private Company() {	}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		
		return instance;
	}
}
