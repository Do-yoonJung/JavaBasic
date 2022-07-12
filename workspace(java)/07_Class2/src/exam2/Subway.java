package exam2;

public class Subway {		//지하철 객체
	
	//멤버변수
	int lineNumber;				//지하철 노선(호선)
	int passengerCount; 		//지히철 노선의 승객 수
	int money;					//지하철 회사의 수입
	
	public Subway() {}
	
	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	//승차 메서드
	void take(int money) {
		this.money += money;	//지하철 회사의 수입에 누적
		passengerCount++;
	}
	
	//버스회사 정보 출력
	void showSubwayInfo() {
		System.out.println("지하철 No. " + lineNumber);
		System.out.println("지하철 승객 수: " + passengerCount);
		System.out.println("지하철 회사 수입: " + money);
		System.out.println("======================================");
	}

}
