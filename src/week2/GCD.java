package week2;

import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  
  private static int gcd_fast(int a, int b) {
	  // make sure a is always greater than b
	  if(a<b) {
		  int tmp = a;
		  a = b;
		  b = tmp;
	  }
	  if(b == 0)
		  return a;
	  int c = a % b;
	  a = b;
	  b = c;
	  return gcd_fast(a,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    
    long startTime = System.nanoTime();
    
    System.out.println(gcd_naive(a, b));
    
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println("runtime:" + totalTime);
    
    startTime = System.nanoTime();
    
    System.out.println(gcd_fast(a, b));
    
    endTime   = System.nanoTime();
    totalTime = endTime - startTime;
    System.out.println("runtime:" + totalTime);
    
  }
}
