package week2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    /**
     * F(from) + F(from+1) + ... + F(to)
     * @param from The beginning of the sum
     * @param to The end of the sum
     * @return The last digit of the partial sum
     * Since Sum[F(0), F(n)] = F(n+2) - 1
     * The partial sum is F(to+2) - 1 - (F(from+1) - 1)
     * which is F(to+2) - F(from+1)
     * The last digit is
     * F((to+2) % 60) % 10 - F((from+1) % 60) % 10
     * if the answer < 0
     * answer += 10
     */
    private static int getFibonacciPartialSumFast(long from, long to) {
    	assertTrue("The 1st input cannot exceed the 2nd one", from <= to);
    	int newTo = (int) ((to + 2) % 60);
    	int newFrom = (int) ((from + 1) % 60);
    	int answer = getFibonacciLastDigit(newTo) - getFibonacciLastDigit(newFrom);
    	if(answer < 0)
    		return answer + 10;
    	return answer;
	}
    
    private static int getFibonacciLastDigit(int n) {
		if(n <= 1)
			return n;
    	long previous = 0;
		long current = 1;
		for(int i = 0; i < n - 1; i++) {
			long tmpPrevious = previous;
			previous = current;
			current = (tmpPrevious + previous) % 10;
		}
		return (int) current;
	}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        
        long startTime = System.nanoTime();
        System.out.println(getFibonacciPartialSumNaive(from, to));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
        
        startTime = System.nanoTime();
        System.out.println(getFibonacciPartialSumFast(from, to));
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("runtime:" + totalTime);
    }
}

