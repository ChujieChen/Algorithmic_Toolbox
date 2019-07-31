package week2;

import java.util.*;

import jdk.internal.dynalink.beans.StaticClass;
/**
 * 
 * @author chujiechen
 *
 */
public class FibonacciHuge {
	// wont work for n > 30, even long cannot hold the number
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (long)tmp_previous + current;
        }

        return current % m;
    }
    
    
    // not fast enough for sample two
    // input 2816213588 239
    // output 151
    private static long getFibonacciHugeFast(long n, long m) {
    	if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }
    
    
    // Pisano period always starts with 0 1
    // And 0 1 always indicates a start of the period
    private static long getFibonacciHugeBest() {
		
    	return -1;
	}
    
    /**
     * @param m The mod. 2 <= m <= 1e3
     */
    private static long getPisanoPeriodLength(int m) {
    	
    	return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        
        long startTime = System.nanoTime();
        System.out.println(getFibonacciHugeNaive(n, m));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
        startTime = System.nanoTime();
        System.out.println(getFibonacciHugeFast(n, m));
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
    }
}

