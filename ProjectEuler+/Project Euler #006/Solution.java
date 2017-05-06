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
      double n = in.nextDouble();
      
      System.out.println(new Double(sumOfFirst(n) * sumOfFirst(n) - squareSumOfFirst(n)).longValue());
    }
  }
  
  // calculate sum numbers from 1 to n
  private static double sumOfFirst(double n) {
    return n * (n + 1) / 2;
  }
  
  // calculate the sum of the square of each number from 1 to n.
  private static double squareSumOfFirst(double n) {
    return n * (n + 1) * (2 * n + 1) / 6;
  }
}