package week2;

import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  
  /*
   * 0 <= n <= 45
   */
  private static long calc_fib_array(int n) {
	  long[] fibArray = new long[n+1];
	  fibArray[0] = 0;
	  fibArray[1] = 1;
	  if(n > 1) {
		  for(int i=2; i<=n; i++) {
			  fibArray[i] = (long)fibArray[i-1] + (long)fibArray[i-2];
		  }
	  }
	  return fibArray[n];
  }
  
  
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

//    System.out.println(calc_fib(n));
    System.out.println(calc_fib_array(n));
  }
}
