import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    BigInteger[][] latticPath = latticPath(500, 500);
      
    for (int i = 0; i < num; i++) {
      int row = in.nextInt();
      int col = in.nextInt();
      System.out.println(latticPath[row][col]);
    }
  }

  // create lattic path matrix using dynamic programming
  private static BigInteger[][] latticPath(int row, int col) {
    BigInteger[][] matrix = new BigInteger[row + 1][col + 1];

    for (int i = 0; i <= row; i++) {
      matrix[i][0] = new BigInteger("1");
    }

    for (int i = 0; i <= col; i++) {
      matrix[0][i] = new BigInteger("1");
    }

    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        matrix[i][j] = matrix[i - 1][j].add(matrix[i][j - 1]);
        matrix[i][j] = matrix[i][j].mod(new BigInteger("1000000007"));
      }
    }

    return matrix;
  }
}