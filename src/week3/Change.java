package week3;

import java.util.Scanner;
/**
 * 
 * @author chujiechen
 * 08/05/2019
 */
public class Change {
    private static int getChange(int m) {
        //write your code here
    	int numCoins = 0;
    	int numCoinsPerType = 0;
    	int[] coins = {10,5,1};
    	for(int coin : coins) {
    		numCoinsPerType = m / coin;
    		numCoins += numCoinsPerType;
    		m = m - numCoinsPerType * coin;
    	}
        return numCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

