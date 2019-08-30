package week6;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        //write your code here
    	int[] numbers = new int[(exp.length() + 1) / 2];
    	for(int i = 0; i < numbers.length; i++) {
    		numbers[i] = Integer.parseInt(exp.substring(2 * i, 2 * i + 1)); 
//    		System.out.println(numbers[i]);
    	}
    	
    	char[] ops = new char[(exp.length() - 1) / 2];
    	for(int i = 0; i < ops.length; i++) {
    		ops[i] = exp.charAt(2 * i + 1); 
//    		System.out.println(ops[i]);
    	}
    	// minTable and maxTable to store min and max
    	int[][] minTable = new int[numbers.length][numbers.length];
    	int[][] maxTable = new int[numbers.length][numbers.length];
    	// minTable[i][j] gives us the minimum value using numbers between ith and jth (including) location
    	// maxTable[i][j] gives us the maximum value using numbers between ith and jth (including) location
    	// initiate minTable[i][i] and maxTable[i][i]
    	for(int i = 0; i < numbers.length; i++) {
    		minTable[i][i] = numbers[i]; 
//    		System.out.println(minTable[i][i]);
    		maxTable[i][i] = numbers[i];
//    		System.out.println(maxTable[i][i]);
    	}
    	for(int start = 1; start < numbers.length; start++) {
    		for(int i = 0; i < numbers.length - start; i++) {
    			int j = start + i;
    			int[] minNmax = MinAndMax(i, j, minTable, maxTable, numbers, ops);
    			minTable[i][j] = minNmax[0]; 
    			maxTable[i][j] = minNmax[1];  
    		}
    	}
    	return maxTable[0][numbers.length - 1];
    }
    
    private static int[] MinAndMax(int i, int j, int[][] minTable, int[][] maxTable, int[] numbers, char[] ops) {
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	for(int k = i; k < j; k++) {
    		int a = (int) eval(maxTable[i][k], maxTable[k+1][j], ops[k]);  
    		int b = (int) eval(maxTable[i][k], minTable[k+1][j], ops[k]);
    		int c = (int) eval(minTable[i][k], maxTable[k+1][j], ops[k]);
    		int d = (int) eval(minTable[i][k], minTable[k+1][j], ops[k]);
    		min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
    		max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
    	}
    	int[] ans = {min, max};
    	return ans;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    	// test MinAndMax
//    	int[][] minTable = {{1,0},{0,5}};
//    	int[][] maxTable = {{1,0},{0,5}};
//    	int[] numbers = {1,5};
//    	char[] ops = {'+'};
//    	System.out.println(MinAndMax(0, 1, minTable, maxTable, numbers, ops)[0]);
    }
}

