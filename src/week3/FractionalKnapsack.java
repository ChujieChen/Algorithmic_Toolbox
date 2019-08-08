package week3;

import static org.junit.Assert.assertEquals;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        assertEquals("values and weights have different lengths", values.length, weights.length);
        //write your code here
        Double[] valuePerWeight = new Double[values.length];
        for(int i=0; i < values.length; i++) {
        	valuePerWeight[i]= (double) values[i] / weights[i]; 
        }
//        Arrays.sort(valuePerWeight, Collections.reverseOrder());
        // the best solution should be sorting values, weights based on valuePerWeight
        // but it is kind of hard to implement
        while(capacity > 0) {
        	double maxVPW = 0;
        	int max_i = -1;
        	for(int i=0; i<valuePerWeight.length; i++) {
        		if(weights[i] == 0) {
        			continue;
        		}
        		if(valuePerWeight[i] > maxVPW) {
        			maxVPW = valuePerWeight[i];
        			max_i = i;
        		}
        	}
//        	System.out.println("max_i: " + max_i);
        	double putWeight = Math.min(capacity, weights[max_i]);
//        	System.out.println("putWeight: " + putWeight);
        	value = value + putWeight * valuePerWeight[max_i];
        	weights[max_i] -= putWeight;
        	capacity -= putWeight;
//        	System.out.println("capacity: " + capacity);
        }
        
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
