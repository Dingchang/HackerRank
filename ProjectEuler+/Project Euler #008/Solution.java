mport java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      int k = in.nextInt();
      char[] arrNum = in.next().toCharArray();

      System.out.println(maxProduct(n, k, arrNum));
    }
  }

  // Find the maximum product of n consecutive digits in the given char array.
  private static int maxProduct(int digit, int num, char[] arrNum) {
    int product = 1;
    int max = 0;

    for (int i = 0; i < digit - num - 1; i++) {
      product = 1;

      for (int j = 0; j < num; j++) {
        product *= arrNum[i + j] - '0';
      }

      if (product > max) {
        max = product;
      }
    }

    return max;
  }
}
