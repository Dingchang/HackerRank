import java.io.*;
import java.util.*;

public class Solution {
    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    private static int[] shiftArray(int[] nums, int length, int remove) {
        int[] arr = new int[length];
        int j = 0;

        for (int i = 0; i < length; ++i) {
            if (nums[i] == remove) {
                ++j;
                arr[i] = nums[i+j];
            } else {
                arr[i] = nums[i+j];
            }
        }

        return arr;
    }

    private static int[] permutation(int nth, int[] nums) {
        nth -= 1;
        int[] digits = new int[nums.length];
        int length = nums.length-1;

        for(int i = 0; i < length+1; ++i) {
            digits[i] = nums[(int)(nth/factorial(length-i))];
            nth %= factorial(length-i);
            nums = shiftArray(nums, nums.length-1, digits[i]);
        }

        return digits;
    }

    private static char intToChar(int n) {
        switch (n) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            default:
                return 'z';
        }
    }

    private static String arrToStr(int[] nums) {
        String str = "";
        for(int i = 0; i < nums.length; i++) {
            str += intToChar(nums[i]);
        }
        return str;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for(int i = 0; i < num; i++) {
            System.out.println(arrToStr(permutation(in.nextInt(), nums)));
        }
    }
}
