package union_find;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import stdlib.StdIn;
import stdlib.StdOut;

public class WeightQuickUnionUF {
	    private int[] id;    // id[i] = component identifier of i
	    private int count;   // number of components
	    private int[] weight;
	    /**
	     * Initializes an empty union¨Cfind data structure with {@code n} sites
	     * {@code 0} through {@code n-1}. Each site is initially in its own 
	     * component.
	     *
	     * @param  n the number of sites
	     * @throws IllegalArgumentException if {@code n < 0}
	     */
	    public WeightQuickUnionUF(int n) {
	        count = n;
	        id = new int[n];
	        weight = new int[n];
	        for (int i = 0; i < n; i++) {
	            id[i] = i;
	            weight[i] = 1;
	        }
	    }

	    /**
	     * Returns the number of components.
	     *
	     * @return the number of components (between {@code 1} and {@code n})
	     */
	    public int count() {
	        return count;
	    }
	  

	    // validate that p is a valid index
	    private void validate(int p) {
	        int n = id.length;
	        if (p < 0 || p >= n) {
	            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
	        }
	    }

	  	
	    
	    public int find_root(int p) {
	        validate(p);
	        while(p != id[p]) p = id[p];
	        return p;
	    }
	    /**
	     * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input, 
	     * where each integer represents some site;
	     * if the sites are in different components, merge the two components
	     * and print the pair to standard output.
	     *
	     * @param args the command-line arguments
	     */
	    public static void main(String[] args) {
	    	long start = System.currentTimeMillis();
	    
	    	try {
	    		File file = new File("D:\\DevelopmentSoftware\\eclipseworkspace\\Algorithm\\res\\largeUF.txt");
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader dr = new BufferedReader(isr);
				String input = dr.readLine();		
				WeightQuickUnionUF uf = new WeightQuickUnionUF(Integer.valueOf(input));
				while((input = dr.readLine()) != null) {
					 int p = Integer.valueOf(input.split(" ")[0]);
			         int q = Integer.valueOf(input.split(" ")[1]);
			         int p_root = uf.find_root(p);
			         int q_root = uf.find_root(q);
			         if(p_root == q_root) continue;
			         if(uf.weight[p_root] > uf.weight[q_root]) {
			        	 uf.id[q_root] = p_root;
			        	 uf.weight[p_root] += uf.weight[q_root];
			         }else {
			        	 uf.id[p_root] = q_root;
			        	 uf.weight[q_root] += uf.weight[p_root];
			         }			         
			         uf.count -- ;
			         StdOut.println(p + " " + q);
				}
				
				 long end = System.currentTimeMillis();
			     StdOut.println(uf.count() + " components");
			     StdOut.println("time is " + (end - start)/1000.0 + "s");
			     
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
	    }
}
