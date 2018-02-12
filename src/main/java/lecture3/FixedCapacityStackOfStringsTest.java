package lecture3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FixedCapacityStackOfStringsTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String[] commands = Files.readAllLines(Paths.get(FixedCapacityStackOfStringsTest.class.getResource("/stack.txt").toURI())).get(0).split(" ");
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
		for(String command : commands) {
			if(command.equalsIgnoreCase("-")) {
				System.out.println("Pop: " + stack.pop());
			} else {
				stack.push(command);
				System.out.println("Push: " + command);
			}
			stack.printStack();
		}
	}
}
