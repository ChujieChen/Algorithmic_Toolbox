package week4;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
        	// i do not get it. does this help?
        	// basically, it sorts point based on y
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
        
        // approach 1
        public double distanceToPoint(Point o) {
        	return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));
        	
        }
        /////////////
    }

    static double minimalDistance(long[] x, long y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        /*
         * approach 1:
         * Point by point
         * n(n-1)/2 ~ O(n^2)
         */
//        Point[] points = new Point[x.length];
//        for(int i=0; i<points.length; i++) {
//        	points[i] = new Point(x[i], y[i]);
//        }
//        for(int i=0; i< points.length - 1; i++) {
//        	for(int j=i+1; j<points.length;j++) {
//        		if(points[i].distanceToPoint(points[j]) < ans) {
//        			ans = points[i].distanceToPoint(points[j]);
//        		}
//        	}
//        }
        
        /*
         * approach 2:
         * described in the pdf
         */
        if(x.length < 4) {
        	return minimalDistanceForFewPoints(x, y);
        }
        
        Point[] points = new Point[x.length];
        for(int i=0; i<points.length; i++) {
        	points[i] = new Point(x[i], y[i]);
        }
        Arrays.sort(points, new Comparator<Point>(){
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return Long.signum(o1.x - o2.x);
			}
        });
        
        int midIdx = points.length / 2;
//        if(midIdx == 0)
//        	return ans;
        
        long[] xLeftHalf = new long[midIdx];
        long[] yLeftHalf = new long[midIdx];
        long[] xRightHalf = new long[points.length - midIdx];
        long[] yRightHalf = new long[points.length - midIdx];
        
        for(int i = 0; i < midIdx; i++) {
        	xLeftHalf[i] = points[i].x;
        	yLeftHalf[i] = points[i].y;
        }
        for(int i=midIdx; i < points.length; i++) {
        	xRightHalf[i-midIdx] = points[i].x;
        	yRightHalf[i-midIdx] = points[i].y;
        }
        
        double d1 = minimalDistance(xLeftHalf, yLeftHalf);
        double d2 = minimalDistance(xRightHalf, yRightHalf);
        double d = Math.min(d1, d2);
        
        // filter
        ArrayList<Point> strip = new ArrayList<Point>();
        for(int i=0; i< points.length; i++) {
        	if(points[i].distanceToPoint(points[midIdx]) < d) {
        		strip.add(points[i]);
        	}
        }
        // sort strip
        Collections.sort(strip);
        double dPrime = Double.POSITIVE_INFINITY;
        for(int i=0; i<strip.size() - 1; i++) {
        	for(int j=i+1; j < strip.size() && j < i+7;j++) {
        		if(strip.get(i).distanceToPoint(strip.get(j)) < dPrime) {
        			dPrime = strip.get(i).distanceToPoint(strip.get(j));
        		}
        	}
        }
        ans = Math.min(d, dPrime);
        
        return ans;
    }
    private static double minimalDistanceForFewPoints(long[] x, long[] y) {
    	double ans = Double.POSITIVE_INFINITY;
    	
    	Point[] points = new Point[x.length];
	      for(int i=0; i<points.length; i++) {
	      	points[i] = new Point(x[i], y[i]);
	      }
	      for(int i=0; i< points.length - 1; i++) {
	      	for(int j=i+1; j<points.length;j++) {
	      		if(points[i].distanceToPoint(points[j]) < ans) {
	      			ans = points[i].distanceToPoint(points[j]);
	      		}
	      	}
	      }
	      return ans;
    }
    

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        long n = nextInt();
        long[] x = new long[(int) n];
        long[] y = new long[(int) n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
