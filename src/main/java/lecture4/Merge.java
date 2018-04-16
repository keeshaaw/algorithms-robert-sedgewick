package lecture4;

public class Merge {
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);
		
		for(int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if		(i > mid) 		a[k] = aux[j++];
			else if (j > hi) 		a[k] = aux[i++];
			else if (less(aux[i], 	aux[j])) a[k] = a[i++];
			else 					a[k] = aux[j++];
		}
		
		assert isSorted(a, lo, hi);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for(int i = lo; i <= hi; i++) {
			if(less(a[i + 1], a[i])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Integer [] a = {2, 1, 9, 3, 787, 32};
		sort(a);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}

}
