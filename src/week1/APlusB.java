package week1;

import java.util.Scanner;

class APlusB {
    static long sumOfTwoDigits(long first_digit, long second_digit) {
        return first_digit + second_digit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();
        System.out.println(sumOfTwoDigits(a, b));
    }
}