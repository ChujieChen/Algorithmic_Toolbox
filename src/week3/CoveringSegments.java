package week3;

import java.util.*;

import org.junit.Test.None;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
    	
    	
    	// scripts below are provided
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        return points;
    }
    
    private static int[] optimalPointsFast(Segment[] segments) {
    	Arrays.sort(segments, Comparator.comparing(seg -> seg.end));
    	List<Integer> pointsList = new ArrayList<>();
    	int currIdx = 0;
    	int lastIdx = 0;
    	while(currIdx < segments.length){
    		int currPoint = segments[currIdx].end;
//    		System.out.println(currPoint);
    		lastIdx = currIdx;
    		for(currIdx = lastIdx + 1; currIdx < segments.length; currIdx++) {
    			if(segments[currIdx].start > currPoint)
    				break;
    		}
    		pointsList.add(currPoint);
    		if(currIdx == segments.length -1)
    			break;
    	}
    	int[] points = new int[pointsList.size()];
    	for(int i=0; i< points.length;i++) {
    		points[i]=  pointsList.get(i);
    	}
    	
    	return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPointsFast(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
