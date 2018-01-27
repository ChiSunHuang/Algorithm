package sorting;

import java.util.Arrays;

public class MergeSort {
	//时间复杂度O(logN),但是需要额外的一个数组来做merge。以空间换时间。在小规模的时候merge可以优化为插入排序会更快(函数图像上也可以看出来)。
	public static int[] arrays_temp;

	public static void sort(int[] a) {
		arrays_temp = new int[a.length];
		sort(a,0,a.length - 1);
	}
	
	public static void sort(int a[],int lo,int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a,lo,mid);
		sort(a,mid + 1,hi);
		if(a[mid + 1] < a[mid]) {
			merge(a,lo,mid,hi);
		}//对于已经有序的两边，不用merge 

	}
	
	public static void merge(int[] a,int lo,int mid,int hi) {
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
