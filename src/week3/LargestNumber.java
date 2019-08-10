package week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
    	
    	// approach 1 - failed
//    	String[] b = new String[a.length];
//    	for(int i = 0; i < a.length - 1; i++) {
//    		int maxIdx = i;
//    		for(int j = i + 1; j < a.length; j++) {
//    			if(a[maxIdx].compareTo(a[j]) > 0) {
//    				// nextNumber should be ahead of currNumber
//    				maxIdx = j;
//    			}
//    		}
//    		// sway maxIdx and i
//    		String tmpNumber = new String(a[maxIdx]);
//    		a[maxIdx] = new String(a[i]);
//    		a[i] = new String(tmpNumber); 
//    	}
    	
    	// approach 2 - works, but not perfect
//    	Arrays.sort(a, new numberComparator());
    	
    	// approach 3
    	List<String> answer = new ArrayList<String>();
    	List<String> Digits = new ArrayList<String>(Arrays.asList(a));
    	
    	while(!Digits.isEmpty()) {
    		String maxDigit = "0";
    		for(String digit : Digits) {
    			if(IsGreaterOrEqual(digit, maxDigit)) {
    				maxDigit = digit;
//    				System.out.println(maxDigit);
    			}
    		}
    		answer.add(maxDigit);
    		Digits.remove(maxDigit);
    	}
    	
    	
    	String result = "";
        for (int i = 0; i < answer.size(); i++) {
            result += answer.get(i);
        }
        return result;
    }
    
    private static boolean IsGreaterOrEqual(String digit, String maxDigit) {
    	String left = digit + maxDigit;
    	String right = maxDigit + digit;
    	if(left.compareTo(right) >= 0)
    		return true;
    	else
    		return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
//        String test1 = "21";
//        String test2 = "22";
//        System.out.println(test1.compareTo(test2));
    }
}


// approach 2
//class numberComparator implements Comparator<String>{
//	@Override
//	public int compare(String a, String b) {
//		
//		if(a.length() == b.length()) {
////			System.out.println("equalLength");
////			System.out.println(a.compareTo(b));
//			return -a.compareTo(b);
//		}
//		StringBuffer newA = null;
//		StringBuffer newB = null;
//		if(a.length() < b.length()) {
////			System.out.println("a shorter than b");
//			newA = new StringBuffer(a);
//			newB = new StringBuffer(b);
//			for(int i = a.length(); i < b.length(); i++) {
//				newA.append(a.charAt(a.length()-1));
////				System.out.println(newA);
//			}
//		}
//		if(a.length() > b.length()) {
////			System.out.println("a longer than b");
//			newA = new StringBuffer(a);
//			newB = new StringBuffer(b);
//			for(int i = b.length(); i < a.length(); i++) {
//				newB.append(b.charAt(b.length()-1));
////				System.out.println(newB);
//			}
//		}
//		
////		System.out.println(newA.toString().compareTo(newB.toString()));
//		return -newA.toString().compareTo(newB.toString());
//	}
//}

