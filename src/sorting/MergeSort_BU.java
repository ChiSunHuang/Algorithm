package sorting;

import java.util.Arrays;

public class MergeSort_BU {
	//�Ե����ϵĹ鲢����
	public static int[] arrays_temp;
	public static int count = 0;
	public static void sort(int[] a) {
		arrays_temp = new int[a.length];
		int N = a.length;
		for(int i = 1 ; i < N  ; i = 2 * i) {  // ������ĳ���
			for(int lo = 0 ; lo + i < N ; lo = lo + 2 * i) {
				if(a[lo + i] > a[lo + i -1]) {  //������򣬾Ͳ���Merge��
					continue;
				}
				merge(a,lo,lo + i - 1,Math.min(lo + i + i - 1, N - 1));  //���һ��������ʣ��Ԫ�ص�����û�дﵽǰ��������ĳ��� ���� N = 6,N = 7  �����鳤��Ϊ2��ʱ��ȡlo+i+i-1��N-1����Сֵ
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
