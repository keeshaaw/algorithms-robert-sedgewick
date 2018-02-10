package lecture2.analysis;

public class ThreeSumBruteForce {
	public static int count(int[] a) {
		int N = a.length;
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				for(int k = j + 1; k < N; k++) {
					int sum = a[i] + a[j] + a[k];
					if(sum == 0) {
						count++;
						System.out.println(a[i] + " + " + a[j] + " + " + a[k] + " = " + sum);
					}
				}
			}
		}
		return count;
	}
}
