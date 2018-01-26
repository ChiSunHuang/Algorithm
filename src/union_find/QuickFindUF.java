package union_find;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import stdlib.StdIn;
import stdlib.StdOut;

public class QuickFindUF {
	 private int[] id;    // id[i] = component identifier of i
	    private int count;   // number of components

	    /**
	     * Initializes an empty union¨Cfind data structure with {@code n} sites
	     * {@code 0} through {@code n-1}. Each site is initially in its own 
	     * component.
	     *
	     * @param  n the number of sites
	     * @throws IllegalArgumentException if {@code n < 0}
	     */
	    public QuickFindUF(int n) {
	        count = n;
	        id = new int[n];
	        for (int i = 0; i < n; i++)
	            id[i] = i;
	    }

	    /**
	     * Returns the number of components.
	     *
	     * @return the number of components (between {@code 1} and {@code n})
	     */
	    public int count() {
	        return count;
	    }
	  
	    /**
	     * Returns the component identifier for the component containing site {@code p}.
	     *
	     * @param  p the integer representing one site
	     * @return the component identifier for the component containing site {@code p}
	     * @throws IllegalArgumentException unless {@code 0 <= p < n}
	     */
	    public int find(int p) {
	        validate(p);
	        return id[p];
	    }

	    // validate that p is a valid index
	    private void validate(int p) {
	        int n = id.length;
	        if (p < 0 || p >= n) {
	            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
	        }
	    }

	    /**
	     * Returns true if the the two sites are in the same component.
	     *
	     * @param  p the integer representing one site
	     * @param  q the integer representing the other site
	     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
	     *         {@code false} otherwise
	     * @throws IllegalArgumentException unless
	     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	     */
	    public boolean connected(int p, int q) {
	        validate(p);
	        validate(q);
	        return id[p] == id[q];
	    }
	  
	    /**
	     * Merges the component containing site {@code p} with the 
	     * the component containing site {@code q}.
	     *
	     * @param  p the integer representing one site
	     * @param  q the integer representing the other site
	     * @throws IllegalArgumentException unless
	     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	     */
	    public void union(int p, int q) {
	        validate(p);
	        validate(q);
	        int pID = id[p];   // needed for correctness
	        int qID = id[q];   // to reduce the number of array accesses

	        // p and q are already in the same component
	        if (pID == qID) return;

	        for (int i = 0; i < id.length; i++)
	            if (id[i] == pID) id[i] = qID;
	        count--;
	    }
	    
	    public int find_root(int p) {
	        validate(p);
	        while(p != id[p]) p = id[p];
	        return p;
	    }
	    
	    public void quick_union(int p, int q) {
	        validate(p);
	        validate(q);

	        
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
	    		File file = new File("D:\\DevelopmentSoftware\\eclipseworkspace\\Algorithm\\res\\tinyUF.txt");
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader dr = new BufferedReader(isr);
				String input = dr.readLine();		
				QuickFindUF uf = new QuickFindUF(Integer.valueOf(input));
				while((input = dr.readLine()) != null) {
					 int p = Integer.valueOf(input.split(" ")[0]);
			         int q = Integer.valueOf(input.split(" ")[1]);
			         //if (uf.connected(p, q)) continue;
			         //uf.union(p, q);
			         int p_root = uf.find_root(p);
			         int q_root = uf.find_root(q);
			         if(p_root == q_root) continue;
			         uf.id[p_root] = q_root;
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
