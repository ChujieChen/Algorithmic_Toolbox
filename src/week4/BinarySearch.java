package week4;

import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
    	/*
    	 *  approach 1: recursive call - divide and conquer
    	 */
//        int left = 0, right = a.length;
//        //write your code here
//        int mid = left + (right - left) / 2;
//        if(x == a[mid]) {
//        	return mid;
//        }
//        else if(x < a[mid]) {
//        	if(left >= mid)
//        		return -1;
//        	int[] newA = Arrays.copyOfRange(a, left, mid);
//        	return binarySearch(newA, x);
//        }
//        else {
//        	if(mid + 1 >= right)
//        		return -1;
//			int[] newA = Arrays.copyOfRange(a, mid + 1, right);
//			return binarySearch(newA, x);
//		}
    	/*
    	 * approach 2: divide and divide 
    	 */
    	int left = 0, right = a.length - 1;
    	while(left <= right) {
    		int mid = left + (right - left)/ 2;
    		if(a[mid] == x)
    			return mid;
    		else if(x < mid){
    			right = mid - 1;				
			}
    		else {
				left = mid + 1;
			}
    	}
    	return -1;
    	
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
