package sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void sort(int[] a) {
		sort(a,0,a.length-1);
	}
	
	public static void sort(int[] a,int lo,int hi) {
		if(hi <= lo + 3) {
			Insertion.sort(a); // 如果数组长度很小，用插入排序会更快
			return;
		}
//		int target = a[lo];
//		int j = partition(a,lo,hi,target,lo);	
		int j = partition(a,lo,hi);	
		//System.out.println(Arrays.toString(a));
		sort(a,lo,j-1);
		sort(a,j+1,hi);

	}
	
	public static int partition(int[] a,int lo,int hi,int target,int oldestLo) {	
		int i = lo;
		int j = hi + 1;
		while(target > a[++i]) {
			if(i == hi) break;
		}
		while(target < a[--j]) {
			
		}
		if(i >= j) {
			swap(a,oldestLo,j);			
			return j;
		}
		swap(a,i,j);		
		return partition(a,i,j-1,target,oldestLo);
	}
	
	//书上的 。思路更清晰
	public static int partition(int[] a,int lo,int hi) {
		int i = lo , j = hi + 1;
		int target = a[lo];
		while(true) {
			while(target > a[++i]) {
				if(i == hi) break;
			}
			while(target < a[--j]) {
				
			}
			if(i >= j) {
				break;
			}
			swap(a,i,j);
		}
		swap(a,lo,j);
		return j;
	}
	
	public static void swap(int[] a,int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		//System.out.println("i:"+i+"j:"+j);
		//System.out.println(Arrays.toString(a));
	}
}
