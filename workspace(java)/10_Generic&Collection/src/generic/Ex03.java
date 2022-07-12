package generic;

class Generic<T> {
	
	T[] str;
	T var;
	
	void setStr(T[] str) {
		this.str = str;
	}
	
	void setVar(T var) {
		this.var = var;
	}
	
	void output() {
		for(T k : str) {
			System.out.println("str 배열요소: " + k);
		}
		System.out.println("var: " + var);
	}
	
}

public class Ex03 {
	public static void main(String[] args) {
		
		//String 타입의 클래스 객체 생성
		Generic<String> st = new Generic<String>();
		
		String[] str = {"홍길동", "이순신", "유관순"};
		
		String var = "김연아";
		
		st.setStr(str);
		st.setVar(var);
		st.output();
		System.out.println();
		
		//Integer 타입의 클래스 객체 생성
		Generic<Integer> it = new Generic<Integer>();
		
		Integer[] iarr = {10,20,30,40,50};
		Integer ivar = 500;
		
		it.setStr(iarr);
		it.setVar(ivar);
		it.output();
		System.out.println();
		
	}
}
