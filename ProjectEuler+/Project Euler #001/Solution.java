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
      System.out.println(sum(n, 3) + sum(n, 5) - sum(n, 15));
    }
  }
  
  /*
   * Calculate the sum of all multiples of the given
   * divisor under bound.
   */
  public static long sum(long bound, long divisor) {
    long fl = (bound - 1) / divisor;
    return divisor * fl * (fl + 1) / 2;
  }
}