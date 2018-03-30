package lecture3;

public interface Stack<Item> {
	
	Item pop();
	
	void push(Item item);
	
	int size();
	
	boolean isEmpty();
	
	void printStack();
}
