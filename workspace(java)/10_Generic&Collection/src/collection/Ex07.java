package collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue 자료구조
 * - Queue는 인터페이스이여서 자식클래스로 객체를 생성하여 사용함.
 * - 대표적인 자식 클래스는 LinkedList임
 * - 특징: 선입선출(FIFO: First In First Out) 구조임
 */

public class Ex07 {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<String>();
		
		//1. offer(): queue에 저장하는 메서드
		queue.offer("100번");
		queue.offer("101번");
		queue.offer("102번");
		queue.offer("103번");
		queue.offer("104번");
		queue.offer("105번");
		
		//2. peek(): queue에 저장된 데이터를 가져오는 메서드
		//   ==> queue에서 데이터를 제거하지 않고 가져오는 메서드
		System.out.println("처음 호출한 번호: " + queue.peek());
		
		//2. poll(): queue에 저장된 데이터를 가져오는 메서드
		//   ==> queue에서 데이터를 제거하고 가져오는 메서드
		while(!queue.isEmpty()) {
			System.out.println("호출한 번호: " + queue.poll());
		}
		
	}

}
