package sorting;

import java.util.Arrays;

/*
 * ���ڶѵ����ȶ���
 * 2018-01-30 16:26
 */
public class MaxPQ<Key extends Comparable<Key>> {
	
	private int N;
	private Key[] array;
	private int max;
	MaxPQ(int max) {
		array = (Key[])new Comparable[max+1];
		this.max = max;
	}
	
	public void insert(Key key) {
		int loc = ++N;
		if(loc >= max) return;  //������������������
		array[loc] = key; 
		swim(loc);
	}
	
	public Key max() {
		return array[1];
	}
	
	public Key delMax() {
		Key max = array[1];
		exch(1, N); //�����һ��Ԫ�طŵ��Ѷ�
		array[N] = null;//��ֹ���������ڴ�й© ����ط�����Ҫ
		N--;	 //�������������ļ���
		sink(1);
		return max;
	}
	
	public boolean isEmpty() {
		if(N == 0) return true;
		return false;
	}
	
	public int size() {
		return N;
	}
	
	//����Ԫ�ص��³�
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2 * k;
			int max = j;
			if(j + 1 <= N) {
				 max = less(j,j+1) ? j + 1 : j;
			}	
			if(!less(k,max)) {
				break;
			}
			exch(k, max);
			k = max;
		}
	}
	
	//����Ԫ�ص��ϸ�
	private void swim(int k) {
		while(k > 1 && less(k/2,k)) {
			exch(k/2,k);
			k = k/2;
		}
	}
	
	private boolean less(int i,int j) {	
		
		return array[i].compareTo(array[j]) < 0 ? true : false;
	
	}
	
	private void exch(int i,int j) {
		Key temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
