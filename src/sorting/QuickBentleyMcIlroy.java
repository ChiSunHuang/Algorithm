package sorting;

import stdlib.StdIn;
import stdlib.StdOut;

public class QuickBentleyMcIlroy {
	//2018-02-05 注释
	/* 三向切分的快速排序。这里的代码是书本网址上复制过来的。有点难，稍微理解了一下。 最后那里将等于V的元素移动到中间那里的第一个for循环个人感觉还可以再优化。
	 * for (int k = lo; k <= p; k++)
            exch(a, k, j--);
              这个for循环当左边等于v的元素比小于的v元素少的时候没有问题，但是当左边等于v的元素远远多于右边小于v的元素的时候，会造成很多不必要的等值交换。
              改成
        int l = lo;
        int left_times = Math.min(j-p,p-l+1);
        int left_for_times = lo + left_times;
        for (; l < left_for_times; l++)
          exch(a, l, j--);
              即可。
       第二个循环也是一样优化。
	 */
    //统计交换的次数 看下有没有优化
	public static int count = 0;
	
	// cutoff to insertion sort, must be >= 1
    private static final int INSERTION_SORT_CUTOFF = 8;

    // cutoff to median-of-3 partitioning
    private static final int MEDIAN_OF_3_CUTOFF = 40;

    // This class should not be instantiated.
    private QuickBentleyMcIlroy() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { 
        int n = hi - lo + 1;

        // cutoff to insertion sort
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        // use median-of-3 as partitioning element
        else if (n <= MEDIAN_OF_3_CUTOFF) {
            int m = median3(a, lo, lo + n/2, hi);
            exch(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            int eps = n/8;
            int mid = lo + n/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi); 
            int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && eq(a[i], v))
                exch(a, ++p, i);
            if (i >= j) break;

            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }


        i = j + 1;
        
        int l = lo;
        int left_times = Math.min(j-p,p-l+1);
        int left_for_times = lo + left_times;
        for (; l < left_for_times; l++)
          exch(a, l, j--);
        
//        for (int k = lo; k <= p; k++)
//            exch(a, k, j--);
        
        int h = hi;
        int right_times = Math.min(h-q+1, q-i);
        int right_for_times = hi - right_times; 
        for(; h > right_for_times ; h--)
        	 exch(a, h, i++);
        
//        for (int k = hi; k >= q; k--)
//            exch(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }


    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }


    // return the index of the median element among a[i], a[j], and a[k]
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;    // optimization when reference equal
        return v.compareTo(w) < 0;
    }

    // does v == w ?
    private static boolean eq(Comparable v, Comparable w) {
        if (v == w) return true;    // optimization when reference equal
        return v.compareTo(w) == 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
    	count ++;
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; quicksorts them
     * (using an optimized version of quicksort); 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        QuickBentleyMcIlroy.sort(a);
        assert isSorted(a);
        show(a);
    }
}
