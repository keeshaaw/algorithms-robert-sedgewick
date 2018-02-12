package lecture3;

public class FixedCapacityStackOfStrings {
	
	private String S[];
	private int N;
	
	public FixedCapacityStackOfStrings(int capacity) {
		this.S = new String[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		S[N++] = item;
	}
	
	public String pop() {
		String item = S[--N];
		S[N] = null;
		return item;
	}
	
	public void printStack() {
		System.out.print("Stack: ");
		for(int i = 0; i < N; i++) {
			System.out.print(S[i] + " ");
		}
		System.out.println();
	}
}
