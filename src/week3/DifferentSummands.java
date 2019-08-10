package week3;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int i=1;
        while(n > 0) {
        	n = n - i;
        	if(n <= i) {
        		summands.add(i-1, n + i);
        		break;
        	}
        	
        	else {
        		summands.add(i-1, i);
        	}
        	i++;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

