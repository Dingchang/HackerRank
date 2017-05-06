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
      System.out.println(palindromeUnder(n));
    }
  }
  
  /* 
   * calculate the largest palindrome of the product of 
   * two 3-digit number under the given bound.
   */
  private static int palindromeUnder(int bound) {
    int max = 0;
    int i = 999;
    
    while (i >= 100) {
      int j = 999;
      
      while (j >= 100) {
        if (i * j <= max) {
          break;
        } else if (isPalindrome(i * j) && i * j < bound) {
          max = i * j;
        }
        j--;
      }
      i--;
    }
    
    return max;
  }
  
  // determine if the given number is palindrome
  private static boolean isPalindrome(int n)
  {
    int temp = 0;
    int num = n;
    
    while (n != 0) 
    {
      temp = 10 * temp + n % 10;
      n /= 10;
    }
    return temp == num;
  }
}

