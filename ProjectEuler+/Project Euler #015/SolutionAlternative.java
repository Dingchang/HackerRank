import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
      
    for (int i = 0; i < num; i++) {
      int row = in.nextInt();
      int col = in.nextInt();
      System.out.println(latticPath(row, col));
    }
  }

  // create a matrix represents the lattic path of each vertice
  private static BigInteger latticPath(int row, int col) {
    BigInteger result = factorial(row + col).divide(factorial(row))
        .divide(factorial(col)).mod(new BigInteger("1000000007"));
    return result;
  }

  // calculate the factorial of the given number
  private static BigInteger factorial(int num) {
    BigInteger[] arr = new BigInteger[num + 1];
    arr[0] = new BigInteger("1");
    arr[1] = new BigInteger("1");

    for (int i = 2; i <= num; i++) {
      arr[i] = new BigInteger(Integer.toString(i)).multiply(arr[i - 1]);
    }

    return arr[num];
  }
}