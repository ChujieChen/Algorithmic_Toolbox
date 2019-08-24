package week5;

import java.util.*;

import com.sun.org.apache.xpath.internal.operations.And;

import sun.security.util.Length;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
    	/**
    	 * approach 1 - Naive way - WRONG
    	 * for - for loop
    	 * Not safe
    	 * e.g. [2 1 2 1 2] and [1 2 1 2]
    	 * This will return 3 since [2 1 2] will be found
    	 * but the longest should be [1 2 1 2]
    	 */
//    	int lastBj = 0;
//    	List<Integer> subsequence = new ArrayList<Integer>();
//    	for(int i = 0; i < a.length; i++) {
//    		for(int j = lastBj; j < b.length; j++) {
//    			
//    		}
//    	}
    	/**
    	 * approach 2 - WRONG
    	 * It looks like a variant of editing distance
    	 * a.length - numOfOperation(insertion, deletion, substitution)
    	 * that is a.length - editDistance
    	 * 
    	 * No, it should be a.length + numInsertion - numOfOperation
    	 * or a.length - numOOfOperation(deletion, substitution)
    	 */
//    	int numInsertion = 0;
////    	int numDeletion = 0;
////    	int numSubstitution = 0;
//    	int[][] D = new int[a.length + 1][b.length + 1];
//    	for(int i = 0; i <= a.length; i++) {
//    		D[i][0] = i;
//    	}
//    	for(int j = 0; j <= b.length; j++) {
//    		D[0][j]= j; 
//    	}
//    	for(int i = 1; i <= a.length; i++) {
//    		for(int j = 1; j <= b.length; j++) {
//    			if(a[i - 1] == b[j - 1]) {
//    				D[i][j] = D[i - 1][j - 1]; 
//    			}  // Match
//    			else {
//    				D[i][j] = D[i - 1][j - 1] + 1;  // substitution
//    			}
//    			D[i][j] = Math.min(D[i - 1][j] + 1, D[i][j]);  // how about deletion
//    			if(D[i][j - 1] + 1 < D[i][j]) {
//    				D[i][j] = D[i][j - 1] + 1;    // Insertion
////    				numInsertion++;   // This is not correct. I have to trace it back to see the final numInsertion
//    			}   			 
//    		}
//    	}
//    	for(int i = 1; i <= a.length; i++) {
//    		for(int j = 1; j <= b.length; j++) {
//    			System.out.print(D[i][j] + " " );
//    		}
//    		System.out.print("\n");
//    	}
//    	/*
//    	 * trace it back to see how many insertions
//    	 */
//    	int i = a.length, j = b.length;
//    	while(i != 0 && j != 0) {
//    		if(i > 0 && D[i][j] == D[i - 1][j] + 1) {
//    			i = i - 1;
//    		}
//    		else if(j > 0 && D[i][j] == D[i][j - 1] + 1) {
//    			j = j - 1;
//    			numInsertion++;
//    		}
//    		else {
//				i = i - 1;
//				j = j - 1;
//			}
//    	}
//    	System.out.println(numInsertion);
//    	System.out.println(D[a.length][b.length]);
    	/**
    	 * approach 3 - Still wrong
    	 * See video: week5 -> String Comparison -> The Alignment Game
    	 * mismatch scores 0
    	 * indel scores 0
    	 */
//  	    int[][] D = new int[a.length + 1][b.length + 1];    // empty D[0][0]
//  	    for(int i = 0; i <= a.length; i++) {
//  		    D[i][0] = i;
//  	    }
//  	    for(int j = 0; j <= b.length; j++) {
//  		    D[0][j] = j;
//  	    }
//  	    for(int i = 1; i <= a.length; i++) {
//  		    for(int j = 1; j <= b.length; j++) {
//  		  	    if(a[i - 1] == b[j - 1]) {
//  				    D[i][j] = D[i - 1][j - 1]; 
//  			    }
//  			    else {
//  				    D[i][j] = D[i - 1][j - 1] + 1;
//  			    }
//  			    D[i][j] = Math.min(D[i][j], D[i - 1][j]+ 1); 
//  			    D[i][j] = Math.min(D[i][j], D[i][j - 1]+ 1);
//  		    }
//  	    }
//    	for(int i = 0; i <= a.length; i++) {
//			for(int j = 0; j <= b.length; j++) {
//				System.out.print(D[i][j] + " " );
//			}
//			System.out.print("\n");
//    	}  	    
//  	    // trace it back to find numMatches
//  	    int numMatches = 0;
//  	    int i = a.length;
//  	    int j = b.length;
//  	    while(i > 0 || j > 0) {
//  	    	if(D[i][j] == D[i - 1][j - 1]) {  // match
//  	    		i = i - 1;
//  	    		j = j - 1;
//  	    		numMatches++;
//  	    	}
//  	    	else if(D[i][j] == D[i - 1][j - 1] + 1) {  // substitution
//  	    		i = i - 1;
//  	    		j = j - 1;
//  	    	}
//  	    	else if(i > 0 && D[i][j] == D[i - 1][j]+ 1) {  // deletion
//  	    		i = i - 1;
//  	    	}
//  	    	else {
//				j = j - 1;  // insertion
//			}
//  	    }
    	/**
    	 * approach 4:
    	 * It's not edit distance anymore!!!
    	 * It's purely alignment score
    	 * Think about using A[][] to store the alignment score
    	 * https://github.com/anoubhav/Coursera-Algorithmic-Toolbox/blob/master/assignment%20solutions/5.4%20LCS%202%20sequences.py
    	 */
    	int A[][] = new int[a.length + 1][b.length + 1];
    	// null does not match any digit
    	for(int i = 0; i < a.length + 1; i++) {  
    		A[i][0] = 0;
    	}
    	for(int j = 0; j < b.length + 1; j++) {
    		A[0][j] = 0; 
    	}
    	// count score
    	for(int i = 1; i < a.length + 1; i++) {
    		for(int j = 1; j < b.length + 1; j++) {
    			if(a[i - 1] == b[j - 1]) {
    				A[i][j] = A[i - 1][j - 1] + 1; 
    			}
    			else {
    				A[i][j] = Math.max(A[i - 1][j - 1], A[i - 1][j]);
    				A[i][j] = Math.max(A[i][j], A[i][j - 1]); 
    			}
    		}
    	}
  	    return A[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

