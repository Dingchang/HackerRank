import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        for(int i = 0; i < num; i++) {
            char[] result = new BigInteger("2").pow(in.nextInt()).toString().toCharArray();
            int sum = 0;
            for (char c : result) {
                sum += c - '0';
            }
            System.out.println(sum);
        }
    }
}