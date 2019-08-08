package week3;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int numFills = 0;
    	int currentStopIdx = -1;  // this is necessary
    	int currentDist = 0;
    	if(tank < stops[0] && tank < dist)
    		return -1;
    	else if(tank > dist)
    		return 0;
    	while(currentStopIdx < stops.length) {
    		// line below is necessary
    		int lastStopIdx = currentStopIdx;
    		// no more need for gas
    		if(currentDist + tank > dist)
    			return numFills;
    		// need gas, check if can reach the next gas stop
    		while(currentStopIdx < stops.length - 1 && stops[currentStopIdx + 1] - currentDist <= tank) {
    			currentStopIdx = currentStopIdx + 1;
    		}
    		// if cannot reach next gas stop
    		if(currentStopIdx == lastStopIdx)
    			return -1;
    		// can reach next gas stop
    		numFills++;
			currentDist = stops[currentStopIdx];
    	}
    	
        return numFills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
