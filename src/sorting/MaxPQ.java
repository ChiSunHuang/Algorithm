package sorting;

import java.util.Arrays;

/*
 * 基于堆的优先队列
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
		if(loc >= max) return;  //这里可以做数组的扩容
		array[loc] = key; 
		swim(loc);
	}
	
	public Key max() {
		return array[1];
	}
	
	public Key delMax() {
		Key max = array[1];
		exch(1, N); //将最后一个元素放到堆顶
		array[N] = null;//防止对象游离内存泄漏 这个地方很重要
		N--;	 //这里可以做数组的减半
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
	
	//堆中元素的下沉
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
	
	//堆中元素的上浮
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
