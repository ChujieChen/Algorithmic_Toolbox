package week4;

import java.util.*;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.print.resources.serviceui;

public class Inversions {
	/**
	 * 
	 * @param a: original array
	 * @param b: empty array having the same length as a
	 * @param left: left end
	 * @param right: right end + 1 = length
	 * @return number of inversions in a
	 */
    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        
        /*
         * approach 1: O(n^2) - no improvement
         */
//        for(int i = left; i < ave; i++) {
//        	for(int j = ave; j < right; j++) {
//        		if(a[i] > a[j])
//        			numberOfInversions++;
//        	}
//        }
        
        /*
         * approach 2: O(nlogn)
         * use mergesort's merge
         * for two sorted arrays a[] b[]
         * if a[i] > b[j]
         * then a[i] also greater than b[j+1],b[j+2]...
         * but to remember: we should not raise numberOfInversions
         * when b[j] > a[i]
         * so numberOfInversions += b.length - j
         * note that `b` below does not start from 0
         */
        int i = left;
        int j = ave;
        while(i < ave && j < right) {
        	if(a[i] > a[j]) {
        		numberOfInversions += right - j;
        		b[i+j-ave] = a[i];
        		i++;
        	}
        	else {
        		b[i+j-ave] = a[j];
        		j++;
        	}
        }
        // move the rest
        while(i < ave && j == right) {
        	b[i+j-ave] = a[i];
    		i++;
        }
        while(j < right && i == ave) {
        	b[i+j-ave] = a[j];
    		j++;
        }
        for(int idx = left; idx < right; idx++) {
        	a[idx] = b[idx];
        }
        return numberOfInversions;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    	
    	// test 
//    	int[] a = {1,2,3,4,5,6}; // 0
//    	int[] b = new int[6];
//    	System.out.println(getNumberOfInversions(a, b, 0, a.length));
//        a = new int[]{6,6,6,6,6,6}; // 0
//    	b = new int[6];
//    	System.out.println(getNumberOfInversions(a, b, 0, a.length));
//    	a = new int[]{6,5,4,3,2,1}; // 15
//    	b = new int[6];
//    	System.out.println(getNumberOfInversions(a, b, 0, a.length));
    	
    }
}

