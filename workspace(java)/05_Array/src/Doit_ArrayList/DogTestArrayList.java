package doit_ArrayList;

import java.util.ArrayList;

public class DogTestArrayList {
	public static void main(String[] args) {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		dogs.add(new Dog("소녀", "리트리버"));
		dogs.add(new Dog("소녀", "리트리버"));
		dogs.add(new Dog("소녀", "리트리버"));
		dogs.add(new Dog("소녀", "리트리버"));
		dogs.add(new Dog("소녀", "리트리버"));
		
		for(Dog d : dogs) {
			System.out.println(d.showDogInfo());
		}
	}
}
