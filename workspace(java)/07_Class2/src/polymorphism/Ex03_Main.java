package polymorphism;

class A {}

class B extends A {}

class C extends A {}

class D extends B {}

class E extends C {}


public class Ex03_Main {

	public static void main(String[] args) {

		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A b1 = new B();
		A c1 = new C();
		A d1 = new D();
		A e1 = new E();
		
		B d2 = new D();
		C e2 = new E();
		
		//B e3 = new E(); //Err
		//C d3 = new D(); //Err
		
	}

}
