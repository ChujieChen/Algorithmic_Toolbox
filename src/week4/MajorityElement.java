package week4;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        /*
         * approach 1: quick sort then count
         */
        // quicksort counts O(nlogn)
//        Arrays.sort(a);
//        int currElement = -1;
//        int currCount = 0;
//        // iteration costs O(n)
//        for(int currIdx = 0; currIdx < a.length; currIdx++) {
//        	if(a[currIdx] > currElement) {
//        		currElement = a[currIdx];
//        		currCount = 1;
//        		if(currCount * 2 > a.length)
//        			return 99;
//        	}
//        	else if(a[currIdx] == currElement) {
//        		currCount++;
//        		if(currCount * 2 > a.length)
//        			return 99;
//        	}
//        }
//        return -1;
        
        /*
         * approach 2
         * divide into halves. if majority element exists,
         * there must at least one half has that majority effect,
         * but not vise versa.
         */
        int mid = left + (right - left) / 2;
        int left_candidate = getMajorityElement(a, left, mid);
        int right_candidate = getMajorityElement(a, mid, right);
        int left_count = 0;
        int right_count = 0;
        for(int i = left; i < right; i++) {
        	if(a[i] == left_candidate)
        		left_count++;
        	if(a[i] == right_candidate)
        		right_count++;
        }
        if(left_count * 2 > (right - left))
        	return left_candidate;
        if(right_count * 2 > (right - left))
        	return right_candidate;
        
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

