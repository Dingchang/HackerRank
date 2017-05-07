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
      System.out.println(nthPrime(n));
    }
  }
  
  // calculate the n-th prime number
  private static int nthPrime(int n) {
    if (n == 1) {
      return 2;
    }
    
    int result = 3;
    for (int i = 1; i < n; result += 2) {
      if (isPrime(result)) {
        i++;
      }
    }
    
    return result - 2;
  }
  
  // determine if a number is a prime number
  private static boolean isPrime(int n) {
    if (n == 1)
      return false;
    else if (n < 4)
      return true;
    else if (n % 2 == 0)
      return false;
    else if (n < 9)
      return true;
    else if (n % 3 == 0)
      return false;
    else {
      long limit = (long) Math.floor(Math.sqrt(n));

      for (int i = 5; i <= limit; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) 
          return false;
      }
    }   
    return true;
  }
}