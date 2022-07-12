package inner;

public class Sub implements Inter{

	@Override
	public int sum(int n1, int n2) {
		
		return n1 + n2;
	}

	@Override
	public int minus(int n1, int n2) {
		
		return n1 - n2;
	}

	
}
