package lecture3;

public class ResizingArrayStackOfStrings {
	
	private String[] s;
	private int N = 0;

	public ResizingArrayStackOfStrings() {
		this.s = new String[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	private void resize(int capacity) {
		String[] array = new String[capacity];
		for(int i = 0; i < N; i++) {
			array[i] = s[i];
		}
		s = array;
	}
	
	public void push(String item) {
		if(N == s.length) {
			resize(s.length * 2);
		}
		s[N++] = item;
	}
	
	public String pop() {
		String item = s[--N];
		s[N] = null;
		if(N > 0 && N <= s.length/4) {
			resize(s.length/2);
		}
		return item;
	}
	
	public void printStack() {
		System.out.print("Stack: ");
		for(int i = 0; i < N; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}
}
