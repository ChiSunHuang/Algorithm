package sorting;
/*
 * 堆排序
 */
public class HeapSort {
	

	public static void sort(int[] a) {		

		int N  = a.length;
		//构造堆
		for(int i = N / 2 ; i >= 1 ; i--) {
			sink(a,i,N);
		}
		while(N > 1) {
			exch(a,1,N);
			N--;
			sink(a,1,N);
		}
	}
	
	//堆顶元素的下沉
	private static void sink(int[] a,int k,int N) {
		while(2*k <= N) {
			int j = 2 * k;
			int max = j;
			if(j + 1 <= N) {
				 max = less(a,j,j+1) ? j + 1 : j;
			}	
			if(!less(a,k,max)) {
				break;
			}
			exch(a,k, max);
			k = max;
		}
	}
	
	private static boolean less(int[] a,int i,int j) {	
		
		return a[i-1] < a[j-1] ? true : false;
	
	}
	
	private static void exch(int[] a,int i,int j) {
		int temp = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = temp;
	}
}
