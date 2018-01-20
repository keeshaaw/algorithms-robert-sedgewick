package lecture2.analysis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ThreeSumBruteForceTest {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		List<String> lists = Files.readAllLines(Paths.get(ThreeSumBruteForceTest.class.getResource("/16ints.txt").toURI()));
		int[] numbers = new int[lists.size()];
		for(int i = 0; i < lists.size(); i++) {
			numbers[i] = Integer.parseInt(lists.get(i));
		}
		
		int result = ThreeSumBruteForce.count(numbers);
		System.out.println("Posible numbers of combintations: " + result);
	}
}
