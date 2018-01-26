package sorting;

import java.util.Arrays;

public class Insertion {
	
	//ʱ�临�Ӷ� O(n^2) ���ǿ�������֮ǰ�źõ�˳�� ��ѡ���������� ����ʵ����֤ ������������ʱ���ѡ��������1.7��
	
	public static void sort(int[] a) {
		int target;
		boolean targetIsChanged = false;
		for(int i = 1 ; i < a.length ; i ++) {
			target = i;
			for(int j = i - 1 ; j >= 0 ; j --) {
				if(a[i] < a[j]) {
					target = j;
				}else {
					break;
				}
			}
			int begin = i;
			int temp = a[i];
			while(begin > target) {
				a[begin] = a[begin-1];
				begin --;
			}
			a[target] = temp;
		}
	}
}
