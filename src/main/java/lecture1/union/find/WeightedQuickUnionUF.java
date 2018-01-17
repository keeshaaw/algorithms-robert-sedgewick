package lecture1.union.find;

public class WeightedQuickUnionUF {

	private int id[];
	private int size[];
	
	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 0;
		}
	}
	
	private int root(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if(size[rootP] > size[rootQ]) {
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
	}
	
	public void printId() {
		for(int i = 0; i < id.length; i++) {
			System.out.print(id[i] + "\t");
		}
	}
}
