import java.io.*;
import java.util.*;

public class Solution {

    private static int sumOfDivisor(int num) {
        int sum = 1;
        int root = (int) Math.sqrt(num);

        // num is a square number
        if(root*root == num) {
            sum += root--;
        }

        for(int i = 2; i <= root; ++i) {
            if (num % i == 0) {
                sum += i + (num / i);
            }
        }

        return sum;
    }

    private static ArrayList<Integer> amNumArr(int num) {
        int[] sodArr = new int[num+1];
        sodArr[0] = 0;
        ArrayList<Integer> amNumArr = new ArrayList<Integer>();

        for(int i=1; i<num+1; ++i) {
            sodArr[i] = sumOfDivisor(i);
        }

        for(int i=220; i<num+1; ++i) {
            if(sodArr[i] > num || sodArr[i] == i) {
                continue;
            } else if(sodArr[sodArr[i]] == i) {
                amNumArr.add(i);
            }
        }

        return amNumArr;
    }

    public static void main(String args[]) {
        ArrayList<Integer> amNumArr = amNumArr(100000);

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long year1, year2;
        int month1, month2, day1, day2;

        for(int i = 0; i < num; i++) {
            int bound = in.nextInt();
            int sum = 0;
            for(int j=0; j<amNumArr.size(); ++j) {
                if(amNumArr.get(j)<bound) {
                    sum += amNumArr.get(j);
                } else {
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}
