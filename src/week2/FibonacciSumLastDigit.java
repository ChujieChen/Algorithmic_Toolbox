package week2;

import java.util.*;

import org.omg.CORBA.Current;
/**
 * 
 * @author chujiechen
 * Given an integer 𝑛, find the last digit of the sum 
 * 𝐹0 +𝐹1 +···+𝐹𝑛.
 */
public class FibonacciSumLastDigit {
	/**
	 * 
	 * @param n First n Fibonacci numbers. 0 <= n <= 1e14
	 * @return last digit of the sum of them
	 */
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;

        long previous_last_digit = 0;
        long current_last_digit  = 1;
        long sum_of_last_digit = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous_last_digit;
            previous_last_digit = current_last_digit;
            current_last_digit = (tmp_previous + current_last_digit) % 10;
            sum_of_last_digit += current_last_digit;
            sum_of_last_digit = sum_of_last_digit % 10;
        }

        return sum_of_last_digit;
    }
    
    /**
     * https://stackoverflow.com/questions/38950579/fibonacci-sum-of-large-numbersonly-last-digit-to-be-printed
     * https://github.com/mablatnik/Algorithmic-Toolbox/blob/master/algorithmic_toolbox/week_2/01_introduction_starter_files/fibonacci_huge/FibonacciHuge.java
     * https://github.com/anoubhav/Coursera-Algorithmic-Toolbox/blob/master/assignment%20solutions/2.6%20lastdigitsum.py
     * @param n 0 <= n <= 1e14
     * @return
     * from last assignment, Fn mod 10 = F(n mod 60) mod 10
     * where 60 is the Pisano period of 10
     * Sum = F(n+2) - 1 -> easy to derive
     * Sum mod 10 = F((n+2) mod 60) mod 10 - 1
     * result has to be >= 0
     * So if F((n+2) mod 60) mod 10 == 0
     * the final answer should be 9
     */
    private static long getFibonacciSumBest(long n) {
    	if(n <= 1)
    		return n;
    	long newN = (n + 2) % 60;
    	int previous = 0;
    	int current = 1;
    	for(int i = 0; i < newN - 1; i++) {
    		int tmpPrevious = previous;
    		previous = current;
    		current = (tmpPrevious + previous) % 10;
    	}
    	if(current - 1 == -1)
    		return 9;
    	return current - 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        
        long startTime = System.nanoTime();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
        startTime = System.nanoTime();
        s = getFibonacciSumFast(n);
        System.out.println(s);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
        startTime = System.nanoTime();
        s = getFibonacciSumBest(n);
        System.out.println(s);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
    }
}

