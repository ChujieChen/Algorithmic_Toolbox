package week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        /**
         * value[i][j]
         * optimal value for i capacity that may uses first j items
         */
        int[][] value = new int[W+1][w.length+1];
        // no items
        for(int i = 0; i <= W; i++) {
        	value[i][0] = 0;
        }
        // no capacity
        for(int j = 0; j <= w.length; j++) {
        	value[0][j] = 0; 
        }
        // more and more items
        for(int j = 1; j <= w.length; j++) {
        	// itemIdx can only be used in w[itemIdx]
        	int itemIdx = j - 1;
        	// Increase capacity
        	for(int i = 1; i <= W; i++) {
//        		if(w[itemIdx] <= i) {
//        			value[i][j] = value[i - w[itemIdx]][j - 1] + w[itemIdx];
//        			int val = value[i][j - 1];
//        			if(val > value[i][j])
//        				value[i][j] = val; 
//        		}    // not so correct
        		// if jth item (itemIdx th item) is not used
        		value[i][j] = value[i][j - 1]; 
        		if(w[itemIdx] <= i) {
    			int val = value[i - w[itemIdx]][j - 1] + w[itemIdx];
    			if(val > value[i][j])
    				value[i][j] = val; 
        		}        		
        	}
        }
        
        result = value[W][w.length];
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

