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
      System.out.println(largestPrimeFactor(n));
    }
  }
  
  /*
   * Calculate the largest prime factor of the given number.
   */
  public static long largestPrimeFactor(long number) {
    long d = 3, lastd = 0;
    long max = (long)Math.sqrt(number);
    while (number % 2 == 0) {
      number /= 2;
    }
    
    if (number == 1) {
      return 2;
    }
    
    while (d <= max) {
      while (number % d == 0) {
        number /= d;
        lastd = d;
      }
      
      d += 2;
    }
    
    return number > lastd ? number : lastd;
  }
}