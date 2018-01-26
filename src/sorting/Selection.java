package sorting;

public class Selection {
	// ±º‰∏¥‘”∂» O(n^2)
	public static int count = 0;
	
	public static void sort(int[] a) {
		
		for(int i = 0 ; i < a.length - 1 ; i ++) {
			int min = i ;
			for(int j = i + 1 ; j < a.length ; j ++) {
				if(a[j] < a[min]) {
					min = j;
				}
//				if(a[j] < a[i]) {
//					int temp = a[i];
//					a[i] = a[j];
//					a[j] = temp;
//					count ++;
//				}
			}
			if(i != min) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
				count ++;
			}
		}
	}
}
