package Class;

public class Ex09_PigSave {

	public static void main(String[] args) {

		//돼지 저금통 객체 생성
		PigSave save = new PigSave(0);
		
		save.deposit(3000);		//입금 메서드 호출
		save.deposit(10000);
		save.deposit(10000);
		save.withdraw(15000);	//출금 메서드 호출
		save.withdraw(10000);	//출금 메서드 호출
		
		//save.balance = 100000;	//이렇게 접근을 하면 안됨 Err
		
	}

}
