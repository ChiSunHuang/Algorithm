package sorting;

import java.util.Arrays;

public class MergeSort {
	//ʱ�临�Ӷ�O(logN),������Ҫ�����һ����������merge���Կռ任ʱ�䡣��С��ģ��ʱ��merge�����Ż�Ϊ������������(����ͼ����Ҳ���Կ�����)��
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
		}//�����Ѿ���������ߣ�����merge 

	}
	
	public static void merge(int[] a,int lo,int mid,int hi) {
		int i = lo;
		int j = mid + 1;
		int k = lo;
		for(int z = lo ; z <= hi ; z ++) {
			arrays_temp[z] = a[z];
		}
		//����д���ԣ���i��jΪ׼�����Ǿ�������д�ĸ���� ��kΪ׼
//		while(i < mid + 1 && j <= hi) {
//			if(arrays_temp[i] < arrays_temp[j]) {
//				a[k++] = arrays_temp[i++];
//			}else {
//				a[k++] = arrays_temp[j++];
//			}
//		}
//		while(i < mid + 1) a[k++] = arrays_temp[i++];
//		while(j <= hi) a[k++] = arrays_temp[j++];
		//���ϵ� ��kΪ׼
		for( ; k<=hi ; k ++) {
			if(i > mid) a[k] = arrays_temp[j++];
			else if(j > hi) a[k] = arrays_temp[i++];
			else if(arrays_temp[j] < arrays_temp[i])  a[k] = arrays_temp[j++];
			else a[k] = arrays_temp[i++];
		}
	}
}
