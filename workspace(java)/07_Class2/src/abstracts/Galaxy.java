package abstracts;

public class Galaxy extends SmartPhone {
	
	@Override
	void spec() {
		company = "삼성";
		name = "Galaxy Note 20";
		color = "화이트";
		size = "20cm";
		weight = "350g";
		price = "120만원";
		
		System.out.println(company  + " / " + name + " / " + size + " / " + weight + " / " + price);
	}

}
