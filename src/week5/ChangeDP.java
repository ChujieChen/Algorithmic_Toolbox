package week5;

import java.util.Scanner;
/**
 * 
 * @author chujiechen
 */
public class ChangeDP {
	/**
	 * 
	 * @param m: Integer money
	 * @return: the minimum number of coins with denominations
	 * 1, 3, 4 that changes money.
	 */
    private static int getChange(int m) {
        //write your code here
    	/*
    	 * approach 1:
    	 * save every best change as an element of an array
    	 */
    	int[] coins = {1, 3, 4};
    	int[] minNumCoins = new int[m + 1];
    	minNumCoins[0] = 0;
    	for(int currMoney = 1; currMoney <= m; currMoney++) {
    		minNumCoins[currMoney] = Integer.MAX_VALUE;
    		for(int coin: coins) {
    			if(currMoney >= coin) {
    				int numCoins = minNumCoins[currMoney - coin] + 1;
    				if(numCoins < minNumCoins[currMoney]) {
    					minNumCoins[currMoney] = numCoins;
    				}
    			}
    		}
    	}
    	
    	/*
    	 * approach 2:
    	 * to save memory
    	 * we only need minNumCoins for curr-1, curr-3, curr-4
    	 * but i do not want to implement it here
    	 */
        return minNumCoins[m];
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        System.out.println(getChange(m));
    	int size = 20;
    	for(int i=0; i < size; i++) {
    		System.out.print(i);
    		System.out.print("\t");
    	}
    	System.out.print("\n");
    	for(int i=0; i < size; i++) {
    		System.out.print(getChange(i));
    		System.out.print("\t");
    	}
    	

    }
}

