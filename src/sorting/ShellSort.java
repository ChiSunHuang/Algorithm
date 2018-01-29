package sorting;

import java.util.Arrays;

public class ShellSort {
	//时间复杂度突破了O(n^2) 比较次数比N^2小 和递增序列有关系。但是还没有到达线性指数级别
	public static void sort(int[] a) {
		int N = a.length;
		int h = 0;
		while(h < N/3) h = 3*h + 1;  //h 等于 1 4 13 40 ... 其他的递增序列也可以，一般用的比较多的是两倍递增，这个递增序列会更快。数学上的证明比较困难。不做研究。
		while(h >= 1) { //相当于在标准插入排序(排序间隔为1)前对数组进行预处理，做一些移动距离比较大的排序，使得整个数组相对有序(小的数基本在前面，大的数基本在后面)。
			for(int i = h ; i < a.length ; i ++) {  //一组一组错开来插入
				int target = i;
				for(int j = i - h ; j >= 0 ; j -= h) {
					if(a[j] > a [i]) {
						target = j;
					}else {
						break;
					}
				}
				//System.out.println("target is " + target);
				int begin = i;
				int temp = a[begin];
				while(begin > target) {
					a[begin] = a[begin - h];
					begin -= h;
				}
				a[target] = temp;
				//System.out.println(Arrays.toString(a));
			}
			h = h/3;
		}
	}
}
