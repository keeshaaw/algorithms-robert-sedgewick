package lecture3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LinkedStackOfStringsTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String commands[] = Files.readAllLines(Paths.get(LinkedStackOfStringsTest.class.getResource("/stack.txt").toURI())).get(0).split(" ");
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		for(int i = 0; i < commands.length; i++) {
			if(commands[i].equalsIgnoreCase("-")) {
				String item = stack.pop();
				System.out.println("Pop: " + item);
			} else {
				stack.push(commands[i]);
				System.out.println("Push: " + commands[i]);
			}
			stack.printStack();
		}
	}
}
