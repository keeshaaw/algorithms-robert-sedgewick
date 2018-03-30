package lecture3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StackLinkedListImpl<Item> implements Stack<Item> {

	private Node first = null;
	private int size = 0;

	private class Node {
		Item item;
		Node next;
	}
	
	/**
	 * Implementation of pop API of the <code>Stack</code>
	 */
	@Override
	public Item pop() {
		Item top = first.item;
		first = first.next;
		size--;
		return top;
	}
	
	/**
	 * Implementation of push API of <code>Stack</code>
	 * Takes an input of generic type <code>Item</code> and pushes it on to the stack.
	 */
	@Override
	public void push(Item item) {
		Node oldFirst = first;
		Node node = new Node();
		node.item = item;
		first = node;
		first.next = oldFirst;
		size++;
	}

	/**
	 * Returns the number of elements in the stack.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Tells if the stack is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Prints the current elements of the stack.
	 */
	@Override
	public void printStack() {
		Node currentNode = first;
		System.out.print("Stack: ");
		while (true) {
			System.out.print(currentNode.item + " ");
			if (currentNode.next == null) {
				System.out.println();
				break;
			}
			currentNode = currentNode.next;
		}
	}

	/**
	 * A client program to test the Linked List implementation of Stack.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		String[] commands = Files.readAllLines(Paths.get(StackLinkedListImpl.class.getResource("/stack.txt").toURI())).get(0).split(" ");

		Stack<String> stack = new StackLinkedListImpl<>();

		for (int i = 0; i < commands.length; i++) {
			if (commands[i].equalsIgnoreCase("-")) {
				String item = stack.pop();
				System.out.println("Pop : " + item);
			} else {
				stack.push(commands[i]);
				System.out.println("Push : " + commands[i]);
			}
			stack.printStack();
		}
	}
}
