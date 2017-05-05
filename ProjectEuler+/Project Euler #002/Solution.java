import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    
    for(int a0 = 0; a0 < num; a0++){
      long n = in.nextLong();
      System.out.println(evenFibonacci(n));
    }
  }
  
  /*
   * Calculate the sum of even Fibonacci numbers under the given bound.
   */
  private static long evenFibonacci(long bound) {
    long odd1 = 1;
    long odd2 = 1;
    long even = 0;
    long sum = 0;
    
    while (even < bound) {
      sum += even;
      odd1 = odd2 + even;
      odd2 = odd1 + even;
      even = odd1 + odd2;
    }
    
    return sum;
  }
}