package collection;

import java.util.ArrayList;
import java.util.List;

/*
 * LinkedList
 * - List 인터페이스의 자식 클래스 중의 한 종류
 * - 특징
 *   1) 인접 참조를 링크해서 체인처럼 관리함
 *   2) 특정 인덱스에서 객체를 제거하거나 추가하게 되면 앞 뒤의 링크만 연결하면 되는 구조
 *   3) 빈번히 객체의 삽입과 삭제가 일어나는 곳에서는 ArrayList 보다 더 큰 성능을 발휘함
 *      (단, 중간에 삽입과 삭제가 일어나는 경우에만 해당)
 */

public class Ex03 {
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		long start, end;
		
		//1. ArrayList로 중간에 데이터를 추가하는데 걸리는 시간
		start = System.nanoTime();		//10억분의 1초

		for(int i=0; i<10000; i++) {
			list1.add(0, i);
		}
		
		end = System.nanoTime();		//10억분의 1초
		
		System.out.println("ArrayList로 추가하는데 걸린 시간: " + (end - start) + "ns");
		
		//2. LinkedList로 중간에 데이터를 추가하는데 걸리는 시간
		start = System.nanoTime();		//10억분의 1초

		for(int i=0; i<10000; i++) {
			list2.add(0, i);
		}
		
		end = System.nanoTime();		//10억분의 1초
		
		System.out.println("LinkedList로 추가하는데 걸린 시간: " + (end - start) + "ns");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
