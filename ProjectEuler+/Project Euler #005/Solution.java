import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      System.out.println(lcmSubN(n));
    }
  }
  
  // calculate the greatest common divisor
  private static long gcd(long num1, long num2) {
    long temp;

    if (num1 < num2) {
      temp = num1;
      num1 = num2;
      num2 = temp;
    }

    while(num2 != 0) {
      temp = num1 % num2;
      num1 = num2;
      num2 = temp;
    }

    return num1;
  }

  // calculate the least common multiple
  private static long lcm(long num1, long num2) {
    return num1 * num2 / gcd(num1, num2);
  }

  // calculate the least common multiple of all positive numbers under the given num
  private static long lcmSubN(int n) {
    if (n == 0) {
      return 1;
    } else {
      return lcm(n, lcmSubN(n - 1));
    }
  }
}

