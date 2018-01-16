package lecture1.union.find;

public class QuickFindUF {
	
	private int ids[];
	
	public QuickFindUF(int N) {
		ids = new int[N];
		for(int i = 0; i < N; i++) {
			ids[i] = i;
		}
	}
	
	public boolean find(int p, int q) {
		return ids[p] == ids[q];
	}
	
	public void union(int p, int q) {
		int idP = ids[p];
		int idQ = ids[q];
		for(int i = 0; i < ids.length; i++) {
			if(ids[i] == idP) ids[i] = idQ;
		}
		for(int i = 0; i < ids.length; i++) {
			System.out.print(ids[i] + "\t");
		}
	}

}
