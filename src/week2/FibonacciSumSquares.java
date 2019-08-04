package week2;

import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciSumSquaresFast(long n) {
    	if (n <= 1)
    		return n;
    	int previous = 0;
    	int current = 1;
    	int lastDigitSum = 1;
    	for (long i = 0; i < n - 1; i++) {
    		int tmpPrevious = previous;
    		previous = current;
    		current = (tmpPrevious + current) % 10;
    		lastDigitSum = (lastDigitSum + (current * current) % 10) % 10;
    	}
    	return lastDigitSum;
    }
    
    /**
     * 
     * @param n 
     * @return the last digit of sum of Fi^2 from 0 to n
     * F_0^2 + ... + F_n^2 = F_n * (F_n + F_{n-1}) = F_n * F_{n+1}
     * Since Fn mod 10 = F(n mod 60) mod 10
     * The final answer is ((F_{n%60}%10) * (F_{(n+1)%60}%10))%10
     */
    private static int getFibonacciSumSquaresBest(long n) {
    	if(n <= 1)
    		return (int) n;
    	int newN = (int) (n % 60);
    	int newNplusOne = (int) ((n+1) % 60);
    	int firstDigit = 0;
    	int secondDigit = 0;
    	int previous = 0;
    	int current = 1;
    	int lastDigitSum = 1;
    	for (long i = 0; i < newNplusOne - 1; i++) {
    		int tmpPrevious = previous;
    		previous = current;
    		current = (tmpPrevious + current) % 10;
    		if(i == newNplusOne - 3)
    			firstDigit = current;
    		else if (i == newNplusOne - 2) {
    			secondDigit = current;
			}
    	}
		
    	return (firstDigit*secondDigit)%10;
	}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        
        long startTime = System.nanoTime();
        System.out.println(getFibonacciSumSquaresNaive(n));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
        startTime = System.nanoTime();
        System.out.println(getFibonacciSumSquaresFast(n));
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
        startTime = System.nanoTime();
        System.out.println(getFibonacciSumSquaresBest(n));
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
    }
}

