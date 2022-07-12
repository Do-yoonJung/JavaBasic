package doit_ArrayList;

public class DogTest {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[5];
		
		dogs[0] = new Dog("소녀", "리트리버");
		dogs[1] = new Dog("행성", "포메라니안");
		dogs[2] = new Dog("우주", "웰시코기");
		dogs[3] = new Dog("페퍼", "보더콜리");
		dogs[4] = new Dog("브랜디", "보더콜리");
		
		for(Dog d : dogs) {
			System.out.println(d.showDogInfo());
		}
	}
}
