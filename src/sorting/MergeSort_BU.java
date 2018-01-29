package sorting;

import java.util.Arrays;

public class MergeSort_BU {
	//自底向上的归并排序
	public static int[] arrays_temp;
	public static int count = 0;
	public static void sort(int[] a) {
		arrays_temp = new int[a.length];
		int N = a.length;
		for(int i = 1 ; i < N  ; i = 2 * i) {  // 子数组的长度
			for(int lo = 0 ; lo + i < N ; lo = lo + 2 * i) {
				if(a[lo + i] > a[lo + i -1]) {  //如果有序，就不用Merge了
					continue;
				}
				merge(a,lo,lo + i - 1,Math.min(lo + i + i - 1, N - 1));  //最后一个子数组剩余元素的数量没有达到前面子数组的长度 比如 N = 6,N = 7  子数组长度为2的时候，取lo+i+i-1和N-1的最小值
				//System.out.println(Arrays.toString(a));
			}
		}
		
	}
			
	public static void merge(int[] a,int lo,int mid,int hi) {
		count++;
		int i = lo;
		int j = mid + 1;
		int k = lo;
		for(int z = lo ; z <= hi ; z ++) {
			arrays_temp[z] = a[z];
		}
		//这样写可以，以i和j为准，但是觉得书上写的更简洁 以k为准
//		while(i < mid + 1 && j <= hi) {
//			if(arrays_temp[i] < arrays_temp[j]) {
//				a[k++] = arrays_temp[i++];
//			}else {
//				a[k++] = arrays_temp[j++];
//			}
//		}
//		while(i < mid + 1) a[k++] = arrays_temp[i++];
//		while(j <= hi) a[k++] = arrays_temp[j++];
		//书上的 以k为准
		for( ; k<=hi ; k ++) {
			if(i > mid) a[k] = arrays_temp[j++];
			else if(j > hi) a[k] = arrays_temp[i++];
			else if(arrays_temp[j] < arrays_temp[i])  a[k] = arrays_temp[j++];
			else a[k] = arrays_temp[i++];
		}
	}
}
