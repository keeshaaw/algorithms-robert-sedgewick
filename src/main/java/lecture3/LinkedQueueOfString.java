package lecture3;

public class LinkedQueueOfString {

	private Node head = null;
	private Node tail = null;

	public LinkedQueueOfString() {
		head = tail = null;
	}

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enqueue(String item) {

		Node node = new Node();
		node.next = null;
		node.item = item;

		if (this.isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public String dequeue() {
		String item = head.item;
		head = head.next;
		if (isEmpty())
			tail = null;
		return item;
	}

	public void printQueue() {
		System.out.print("Queue: ");
		Node headTemp = head;
		while (true) {
			System.out.print(headTemp.item + " ");
			if (headTemp.next == null)
				break;
			headTemp = headTemp.next;
		}
		System.out.println();
	}
}
