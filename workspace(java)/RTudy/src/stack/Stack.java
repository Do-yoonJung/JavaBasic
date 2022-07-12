package stack;

public class Stack {
	
	public String[] arr = new String[10];
	
	public Stack() { }
	
	public void push(String input) {
		
		for(int i=0; i<arr.length; i++) {
			if(arr[arr.length - 1] != null) {
				System.out.println("Stack Overflow!");
				break;
			}else if(arr[i] == null) {
				this.arr[i] = input;
				break;
			}
		}
		
	}
	
	public void pop() {
		
		for(int i=0; i<arr.length; i++) {
			if(arr[arr.length - 1] != null) {
				this.arr[arr.length - 1] = null;
				break;
			}else if(arr[i] == null) {
				this.arr[i-1] = null;
				break;
			}
		}
		
	}
	
	public String getItem() {
		
		String item = null;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[arr.length - 1] != null) {
				item = arr[arr.length - 1];
			}else if(arr[i] == null) {
				item = arr[i-1];
				break;
			}
		}
		
		return item;
		
	}
	
	public static void main(String[] args) {
		
		// 배열 생성 메서드
		Stack stack = new Stack();
		
		// push
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		stack.push("8");
		stack.push("9");
		stack.push("10");
		stack.push("11");
		
		// pop
		stack.pop();
		
		// getItem
		System.out.println(stack.getItem());
		
		// print
		
		for(int i=0; i<stack.arr.length; i++) {
			System.out.println(stack.arr[i]);
		}
		
		
	}
}

