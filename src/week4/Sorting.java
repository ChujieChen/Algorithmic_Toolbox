package week4;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
    	//write your code here
    	
    	int m1 = l;
    	int m2 = r;
    	/*
    	 * approach 1: find no-greater-than
    	 * then smaller than
    	 */
    	// get no-greater-than region
//    	int x = a[l];
//    	// x should be the one
//    	for (int i = l + 1; i <= r; i++) {
//    		if(a[i] <= x) {
//    			m1++;
//    			int t = a[i];
//    			a[i] = a[m1]; 
//    			a[m1] = t; 
//    		}
//    	}
//    	int t = a[l];
//        a[l] = a[m1];
//        a[m1] = t;
//        
//        m2 = m1;
//    	// divide this region into two
//    	for(int i = m2 - 1; i >= l; i--) {
//    		if(a[i] >= x) {
//    			m1--;
//    			t = a[i];
//    			a[i] = a[m1]; 
//    			a[m1] = t; 
//    		}
//    	}
//    	t = a[m2];
//        a[m2] = a[m1];
//        a[m1] = t;
//        
//    	int[] m = {m1, m2};
//    	// for test
//        for(int i=0; i<a.length;i++) {
//        	System.out.print(a[i]);
//        	System.out.print(" ");
//        }
//        ///////////
//    	return m;
    	/*
    	 * approach 2
    	 * from left to right: smaller
    	 * from right to left: greater
    	 */
//    	int x = a[l];
//    	// x should be the one
//    	for (int i = l + 1; i <= r; i++) {
//    		if(a[i] < x) {
//    			m1++;
//    			int t = a[i];
//    			a[i] = a[m1]; 
//    			a[m1] = t; 
//    		}
//    	}
//    	int t = a[l];
//        a[l] = a[m1];
//        a[m1] = t;
//        
//        
//        for (int j = r; j >= l; j--) {
//    		if(a[j] > x) {
//    			t = a[j];
//    			a[j] = a[m2]; 
//    			a[m2] = t; 
//    			m2--;
//    		}
//    	}
//        int[] m = {m1, m2};
//	     // for test
////        for(int i=0; i<a.length;i++) {
////	      	System.out.print(a[i]);
////	      	System.out.print(" ");
////	    }
//        return m;
        
        /*
         * approach 3: single scan
         * https://github.com/mablatnik/Algorithmic-Toolbox/blob/master/algorithmic_toolbox/week_4/03_divide_and_conquer_starter_files_20160804/sorting/Sorting.java
         */
    	int x = a[l];
        for(int i=l; i<=m2; i++) {  // starts from l instead of 0 !!!
//        	System.out.println(i);
        	if(a[i] < x) {
        		int temp = a[i];
        		a[i] = a[m1];
        		a[m1] = temp; 
        		m1++;
        	}
        	while(a[i] > x && i <= m2) { // the second condition is important
        		int temp = a[i];
        		a[i] = a[m2];
        		a[m2] = temp; 
        		m2--;
			}
        }
        int[] m = {m1, m2};
        // for test
//	    for(int i=0; i<a.length;i++) {
//	      	System.out.print(a[i]);
//	      	System.out.print(" ");
//	    }
	    ////////
	    return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
//        int m = partition2(a, l, r);
//        randomizedQuickSort(a, l, m - 1);
//        randomizedQuickSort(a, m + 1, r);
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        // test partition3
//        int[] a = {6,2,5,3,6,8,7};
//        int[] m = partition3(a, 0, a.length - 1);
//        System.out.println(" ");
//        System.out.println(m[0]);
//        System.out.println(m[1]);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

