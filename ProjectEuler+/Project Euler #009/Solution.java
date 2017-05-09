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
      long n = in.nextLong();
      System.out.println(pythagorean(n));
    }
  }

  // find the product of pythagorean triplet such that a + b + c = num
  private static long pythagorean(long num) {
    long product = -1;

    for (int a = 3; a <= Math.ceil(num / 3); a++) {
      long b = (num * num - 2 * num * a) / (2 * num - 2 * a);
      long c = num - a - b;

      if (a * a + b * b == c * c
          && a * b * c > product) {
        product = a * b * c;
      }
    }

    return product;
  }
}
