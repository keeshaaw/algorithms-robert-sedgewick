package lecture1.union.find;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WeightedQuickUnionUFTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		List<String> lines = Files.readAllLines(Paths.get(WeightedQuickUnionUFTest.class.getResource("/TinyUF.txt").toURI()));
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(Integer.parseInt(lines.get(0).trim()));
		
		uf.printId();
		System.out.println("Initial Id");
		
		for(int i = 1; i < lines.size(); i++) {
			String[] pq = lines.get(i).split(" ");
			int p = Integer.parseInt(pq[0].trim());
			int q = Integer.parseInt(pq[1].trim());
			if(!uf.find(p, q)) {
				uf.union(p, q);
				uf.printId();
				System.out.println("union (" + p + ", " + q + ")");
			}
		}
	}
}
