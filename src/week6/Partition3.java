package week6;

import java.util.*;


import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
    	int totalSum = 0;
    	if(A.length < 3) {
    		System.out.println("No enough numbers");
    		return 0;
    	}
    	for(int i = 0; i < A.length; i++) {
    		totalSum += A[i];
    	}
    	if(totalSum % 3 != 0) {
    		System.out.println("Total sum can not be divided by 3");
    		return 0;
    	}
    	int sum = totalSum / 3;
    	/*
    	 * the question becomes a Knapsack with capacity sum
    	 since the value of each item is equal to its weight
    	 as long as there is no more space in Knapsack
    	 it is an optimal partition
    	 once a set of numbers has been found
    	 reconstruct the partition and delete them from []A
    	 in other words, if we can find three solutions make
    	 value(sum, i) = sum and if they use different numbers
    	 we should return 1
    	 */
    	// https://www.techiedelight.com/0-1-knapsack-problem/
    	// https://www.techiedelight.com/3-partition-problem/
    	int result = 0;
    	if(subsetSum(A, A.length - 1, sum, sum, sum)) {
    		result = 1;
    		System.out.println("It can be done");
    	}
        return result;
    }
    
    private static boolean subsetSum(int[] A, int currNumIdx, int sum1, int sum2, int sum3) {
    	if(sum1 == 0 && sum2 == 0 && sum3 == 0) {
    		return true;
    	}
    	if(currNumIdx < 0) {
    		return false;
    	}
    	// case1: current number will go into set1
    	boolean caseOne = false;
    	if(A[currNumIdx] <= sum1) {
    		caseOne = subsetSum(A, currNumIdx - 1, sum1 - A[currNumIdx], sum2, sum3);
    	}
    	// case2: current number will go into set2
    	boolean caseTwo = false;
    	if(!caseOne && A[currNumIdx] <= sum2) {
    		caseTwo = subsetSum(A, currNumIdx - 1, sum1, sum2 - A[currNumIdx], sum3);
    	}
    	// case3: current number will go into set3
    	boolean caseThree = false;
    	if(!caseOne && !caseTwo && A[currNumIdx] <= sum3) {
    		caseThree = subsetSum(A, currNumIdx - 1, sum1, sum2, sum3 - A[currNumIdx]);
    	}
    	return(caseOne || caseTwo || caseThree);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] A = new int[n];
//        for (int i = 0; i < n; i++) {
//            A[i] = scanner.nextInt();
//        }
        int[] A = {17, 59, 34, 57, 17, 23, 67, 1, 18, 2, 59};
        System.out.println(partition3(A));
    }
}

