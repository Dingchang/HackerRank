import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int time = in.nextInt();

    for (int t = 0; t < time; t++) {
      int line = in.nextInt();
      int[][] matrix = new int[line][line];

      // fill with 0
      for (int[] row : matrix) {
        Arrays.fill(row, 0);
      }

      for (int i = 0; i < line; i++) {
        for (int j = 0; j <= i; j++) {
          matrix[j][i-j] = in.nextInt();
        }
      }

      System.out.println(maxPath(matrix, line));
    }
  }

  public static int maxPath(int[][] matrix, int line) {
    int[][] memory = new int[line][line];
    int max = 0;

    for (int i = 0; i < line; i++) {
      for (int j = 0; j < line; j++) {
        if (i + j >= line) {
          continue;
        }

        if (i == 0 && j == 0) {
          memory[0][0] = matrix[0][0];
        } else if (i == 0) {
          memory[i][j] = memory[i][j-1] + matrix[i][j];
        } else if (j == 0) {
          memory[i][j] = memory[i-1][j] + matrix[i][j];
        } else {
          if (matrix[i][j] + memory[i][j-1] > matrix[i][j] + memory[i-1][j]) {
            memory[i][j] = matrix[i][j] + memory[i][j-1];
          } else {
            memory[i][j] = matrix[i][j] + memory[i-1][j];
          }
        }
      }
    }

    for (int i = 0; i < line; i++) {
      if (memory[i][line-i-1] > max) {
        max = memory[i][line-i-1];
      }
    }

    return max;
  }
}