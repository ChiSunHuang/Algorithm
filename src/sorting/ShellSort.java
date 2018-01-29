package sorting;

import java.util.Arrays;

public class ShellSort {
	//ʱ�临�Ӷ�ͻ����O(n^2) �Ƚϴ�����N^2С �͵��������й�ϵ�����ǻ�û�е�������ָ������
	public static void sort(int[] a) {
		int N = a.length;
		int h = 0;
		while(h < N/3) h = 3*h + 1;  //h ���� 1 4 13 40 ... �����ĵ�������Ҳ���ԣ�һ���õıȽ϶������������������������л���졣��ѧ�ϵ�֤���Ƚ����ѡ������о���
		while(h >= 1) { //�൱���ڱ�׼��������(������Ϊ1)ǰ���������Ԥ������һЩ�ƶ�����Ƚϴ������ʹ�����������������(С����������ǰ�棬����������ں���)��
			for(int i = h ; i < a.length ; i ++) {  //һ��һ���������
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
