package week5;

import java.util.*;

public class PrimitiveCalculator {
	/**
	 * Not safe. For example, n = 10
	 * @param n
	 * @return
	 */
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    private static List<Integer> optimal_sequenceDP(int n){
    	List<Integer> sequence = new ArrayList<Integer>();
//    	sequence.add(0, 1);
    	List<Integer> numOfOperation = new ArrayList<Integer>();
    	int[] previousNum = new int[n + 1];
    	previousNum[1] = 0;
    	numOfOperation.add(0, 0);  // for n = 0
    	numOfOperation.add(1, 0);  // for n = 1
    	for(int num = 2; num <= n; num++) {
//    		System.out.println(num);
    		int minNumOperation = numOfOperation.get(num - 1) + 1;
    		previousNum[num] = num - 1;
    		if(num % 3 == 0) {
    			if(minNumOperation > numOfOperation.get(num / 3) + 1) {
    				minNumOperation = numOfOperation.get(num / 3) + 1;
    				previousNum[num] = num / 3;
    			}
    		}
			if(num % 2 == 0) {
				if(minNumOperation > numOfOperation.get(num / 2) + 1) {
					minNumOperation = numOfOperation.get(num / 2) + 1;
    				previousNum[num] = num / 2;
				}
			}
			numOfOperation.add(num, minNumOperation);
    	}
//    	System.out.println(previousNum);
    	for(int i = n; i != 0; i = previousNum[i]) {
//    		System.out.println(i);
    		sequence.add(i);
    	}
    	Collections.reverse(sequence);
    	return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        List<Integer> sequence = optimal_sequence(n);
        List<Integer> sequence = optimal_sequenceDP(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

