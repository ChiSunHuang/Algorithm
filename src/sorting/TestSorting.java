package sorting;

import java.util.Arrays;

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
		  
	}
}
