import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    private static int[] buildFactDigitArr(int num) {
        int[] digits = new int[num+1];
        digits[0] = 1;                          // 0! = 1
        BigInteger fact = new BigInteger("1");

        for(int i = 1; i <= num; ++i) {
            fact = fact.multiply(new BigInteger(Integer.toString(i)));
            digits[i] = sumOfDigits(fact);
        }

        return digits;
    }

    private static int sumOfDigits(BigInteger num) {
        String digits = num.toString();
        int length = digits.length();
        int sum = 0;

        for(int i = 0; i < length; ++i) {
            sum += digits.charAt(i) - '0';
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] digits = buildFactDigitArr(1000);

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long year1, year2;
        int month1, month2, day1, day2;

        for (int i = 0; i < num; i++) {
            int pos = in.nextInt();
            System.out.println(digits[pos]);
        }
    }
 }
