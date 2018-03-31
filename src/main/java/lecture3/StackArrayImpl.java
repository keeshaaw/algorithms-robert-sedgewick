package lecture3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StackArrayImpl <Item> implements Stack<Item> {
	
	private Item stack[];
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public StackArrayImpl() {
		this.stack = (Item[]) new Object[1];
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int size) {
		Item[] copy = (Item[])new Object[size];
		for(int i = 0; i < N; i++) {
			copy[i] = stack[i];
		}
		stack = copy;
	}

	@Override
	public Item pop() {
		Item item = stack[--N];
		stack[N] = null;
		if(N > 0 && N == stack.length/4) resize(stack.length/2);
		return item;
	}

	@Override
	public void push(Item item) {
		if(N == stack.length) resize(2 * stack.length);
		stack[N++] = item;
	}

	@Override
	public int size() {
		return this.N;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public void printStack() {
		System.out.print("Stack : ");
		for(int i = N - 1; i >= 0; i--)
			System.out.print(stack[i] + " ");
		
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		String[] commands = Files.readAllLines(Paths.get(StackArrayImpl.class.getResource("/stack.txt").toURI())).get(0).split(" ");
		
		Stack<String> stack = new StackArrayImpl<>();
		
		for(String command : commands) {
			if(command.equalsIgnoreCase("-")) {
				String item = stack.pop();
				System.out.println("Pop: " + item);
			} else {
				stack.push(command);
				System.out.println("Push: " + command);
			}
			stack.printStack();
		}
	}
}
