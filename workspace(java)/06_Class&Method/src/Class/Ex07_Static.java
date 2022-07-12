package Class;

public class Ex07_Static {

	public static void main(String[] args) {
		System.out.println("num: " + Static.num);
		
		System.out.println("adder() 메서드 호출: " + Static.adder(150, 36));
		
		Static static1 = new Static();
		System.out.println("su1: " + static1.su1);
		System.out.println("su2: " + static1.su2);
		static1.sum();
	}

}
