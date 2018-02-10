package lecture3;

public class LinkedStackOfStrings {
	
	private Node first = null;

	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public void push(String item) {
		Node node = new Node();
		node.item = item;
		node.next = first;
		first = node;
	}
	
	public void printStack() {
		Node currentNode = first;
		System.out.print("Stack: ");
		while(true) {
			System.out.print(currentNode.item + " ");
			if(currentNode.next == null) {
				System.out.println();
				break;
			}
			currentNode = currentNode.next;
		}
	}
}
