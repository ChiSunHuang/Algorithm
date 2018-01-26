package sorting;

import java.util.Arrays;

public class TestSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[] arr = {5,3,7,2,6,7,6,5,4,1,9,8};
		  System.out.println("======= selection sort ========");
		  System.out.println(Arrays.toString(arr));
		  Selection.sort(arr);
		  System.out.println(Arrays.toString(arr));
		  System.out.println("======= selection sort ========");
		  System.out.println("======= insertion sort ========");
		  int[] arr_2 = {3,5,7,2,6,7,6,5,4,1,9,8};
		  System.out.println(Arrays.toString(arr_2));
		  Insertion.sort(arr_2);
		  System.out.println(Arrays.toString(arr_2));
		  System.out.println("======= insertion sort ========");
	}
}
