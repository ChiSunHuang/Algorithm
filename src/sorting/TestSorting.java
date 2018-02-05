package sorting;

import java.util.Arrays;
import java.util.Stack;

public class TestSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int[] selection_input = {5,3,7,2,6,7,6,5,4,1,9,8};
		  System.out.println("======= selection sort ========");
		  System.out.println(Arrays.toString(selection_input));
		  
		  Selection.sort(selection_input);
		  
		  System.out.println(Arrays.toString(selection_input));
		  System.out.println("======= selection sort ========");
		  
		  System.out.println("======= insertion sort ========");
		  int[] insertion_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(insertion_input));
		  
		  Insertion.sort(insertion_input);
		  
		  System.out.println(Arrays.toString(insertion_input));
		  System.out.println("======= insertion sort ========");
		  
		  System.out.println("======= shell sort ========");
		  int[] shellSort_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(shellSort_input));
		  
		  ShellSort.sort(shellSort_input);
		  
		  System.out.println(Arrays.toString(shellSort_input));
		  System.out.println("======= shell sort ========");
		  
		  System.out.println("======= merge sort ========");
		  int[] mergeSort_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(mergeSort_input));
		  
		  MergeSort.sort(mergeSort_input);
		  
		  System.out.println(Arrays.toString(mergeSort_input));
		  System.out.println("======= merge sort ========");
		  
		  System.out.println("======= merge sort BU========");
		  int[] mergeSortBU_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(mergeSortBU_input));
		  
		  MergeSort_BU.sort(mergeSortBU_input);
		  
		  System.out.println(Arrays.toString(mergeSortBU_input));
		  System.out.println("merge count is " + MergeSort_BU.count);
		  System.out.println("======= merge sort BU ========");
		  
		  System.out.println("======= quick sort ========");
		  int[] quickSort_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(quickSort_input));
		  
		  QuickSort.sort(quickSort_input);
		  
		  System.out.println(Arrays.toString(quickSort_input));
		  System.out.println("======= quick sort ========");
		  
		  System.out.println(Arrays.toString(mergeSortBU_input));
		  System.out.println("merge count is " + MergeSort_BU.count);
		  System.out.println("======= merge sort BU ========");
		  
		  System.out.println("======= MaxPQ test ========");
		  MaxPQ pq = new MaxPQ<>(16);
		  int[] MaxPQTest_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(MaxPQTest_input));
		  for(int i : MaxPQTest_input) {
			  pq.insert(i);
		  }
		  Stack stack = new Stack();
		  while(!pq.isEmpty()) {			 
			  stack.push(pq.delMax());
		  }
		  while(!stack.isEmpty()) {			 
			  System.out.print(stack.pop() + " ");			  
		  }
		  System.out.println();
		  System.out.println("======= MaxPQ test ========");
		  
		  System.out.println("======= heap sort ========");
		  int[] heapsort_input = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(heapsort_input));
		  
		  HeapSort.sort(heapsort_input);
		  
		  System.out.println(Arrays.toString(heapsort_input));
		  System.out.println("======= heap sort ========");
		  
		  
		  
		  System.out.println("======= Bentley-McIlroy 3-way sort ========");
		  Integer[] QuickBentleyMcIlroy_input = {3,3,3,2,3,3,3,3,2,3,3,3};
		  System.out.println(Arrays.toString(QuickBentleyMcIlroy_input));
		  
		  QuickBentleyMcIlroy.sort(QuickBentleyMcIlroy_input);
		  
		  System.out.println(Arrays.toString(QuickBentleyMcIlroy_input));
		  System.out.println(QuickBentleyMcIlroy.count);
		  System.out.println("======= Bentley-McIlroy 3-way sort ========");
		  
	}
}
