package lecture3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LinkedQueueOfStringTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String[] commands = Files.readAllLines(Paths.get(LinkedQueueOfStringTest.class.getResource("/queue.txt").toURI())).get(0).split(" ");
		
		LinkedQueueOfString queue = new LinkedQueueOfString();
		for(String command : commands) {
			if(command.equalsIgnoreCase("-")){
				System.out.println("Dequeue: " + queue.dequeue());
			} else {
				queue.enqueue(command);
				System.out.println("Enqueue: " + command);
			}
			queue.printQueue();
		}
	}
}
