package sorting;

import java.util.Arrays;

public class Insertion {
	
	//时间复杂度 O(n^2) 但是可用利用之前排好的顺序 而选择排序则不行 经过实验验证 插入排序所花时间比选择排序少1.7倍
	
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
