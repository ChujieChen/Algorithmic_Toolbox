package week4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        /*
         * approach 1:
         * sort starts, ends and points individually
         * scan from min(points, starts)
         * track numRegion: once a start, numRegion++; once an end, numRegion--
         * track count on each point: numRegion is the count for that point
         */
        // this is going to be complicated for java
        // for python, this method is very easy to do
        // for java, it's hard to get correct indexes of points after sorting
        
        /*
         * approach 2:
         * Instructor:
         * https://www.coursera.org/learn/algorithmic-toolbox/discussions/weeks/4/threads/QJ1jK9wNEeWdPBL2iFTrAw/replies/Ihiw4txhEeWK5g7mfcS2Xw/comments/oyAMaeIiEeWyqwpvChh66Q
         * basically it is the same as i thought
         * it turns out this is not a divide-and-conquer problem
         * whatever
         */
        
        /*
         * HashMap would not work due to collisions
         * Creating Objects instead
         */
        int numOfRegion = 0;
        
        assertEquals(starts.length, ends.length);
        Point[] allObjArray = new Point[starts.length + ends.length + points.length];
        for(int i = 0; i < starts.length; i++) {
        	allObjArray[i] = new Point(i, starts[i], 's');
        }
        for(int i = starts.length; i < starts.length + ends.length; i++) {
        	allObjArray[i] = new Point(i-starts.length, ends[i-starts.length], 'e');
        }
        for(int i = starts.length + ends.length; i < starts.length + ends.length + points.length; i++) {
        	allObjArray[i] = new Point(i-(starts.length + ends.length), points[i-(starts.length + ends.length)], 'p');
        }
        Arrays.sort(allObjArray); // quickSort costs O((s+e+p)log(s+e+p))
        for(int i = 0; i < allObjArray.length; i++) {
        	// char is one of 8 primitive types in java
        	if(allObjArray[i].c == 's') {
        		numOfRegion++;   		
        	}
        	if(allObjArray[i].c == 'e') {
        		numOfRegion--;
        	}
        	if(allObjArray[i].c == 'p') {
        		cnt[allObjArray[i].index] = numOfRegion;
        	}
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
    	
    	// for test
//    	int[] starts = {0,7};
//    	int[] ends = {5,10};
//    	int[] points = {1,6,11};
    	///////////
    	
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

class Point implements Comparable<Point>{
	public int index;
	int value;
	char c;
	public Point(int index, int value, char c) {
		this.index = index;
		this.value = value;
		this.c = c;
	}
	public int getIndex() {
		return index;
	}
	public int getValue() {
		return value;
	}
	public char getC() {
		return c;
	}
	@Override
	public int compareTo(Point p) {
		// TODO Auto-generated method stub
		return this.value - p.value;
	}
}

