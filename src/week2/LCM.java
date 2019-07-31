package week2;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_fast(int a, int b) {
	  // make sure that a is always greater than b
	  if(a < b) {
		  int tmp = a;
		  a = b;
		  b = tmp;
	  }
	  for(int i = a/b; i <= a; i++) {
		  long cm = (long) i * b;
		  if(cm % a == 0)
			  return cm;
	  }
	  return -1;
  }
  
  private static int gcd_euclidean(int a, int b) {
	  if(b == 0)
		  return a;
	  int remainder = a % b;
	  return gcd_euclidean(b, remainder);
  }
  // best way: a*b / gcd(a,b)
  private static long lcm_best(int a, int b) {
	  int gcd = gcd_euclidean(a, b);
	  return (long) a * b / gcd;
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    
    long startTime = System.nanoTime();
//    System.out.println(lcm_naive(a, b));
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println("runtime:" + totalTime);
    
    startTime = System.nanoTime();
    System.out.println(lcm_fast(a, b));
    endTime   = System.nanoTime();
    totalTime = endTime - startTime;
    System.out.println("runtime:" + totalTime);
    
    startTime = System.nanoTime();
    System.out.println(lcm_best(a, b));
    endTime   = System.nanoTime();
    totalTime = endTime - startTime;
    System.out.println("runtime:" + totalTime);
  }
}
