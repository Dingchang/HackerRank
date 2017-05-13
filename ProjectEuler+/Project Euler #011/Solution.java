import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] grid = new int[20][20];

    for(int i = 0; i < 20; i++){
      for(int j=0; j < 20; j++){
        grid[i][j] = in.nextInt();
      }
    }

    System.out.println(Math.max(findMaxInRow(grid, 20, 4), 
      Math.max(findMaxInCol(grid, 20, 4), Math.max(findMaxInDiagonal(grid, 20, 4),
      findMaxInDiagonal2(grid, 20, 4)))));
  }
  
  // calculate the max product in left to right direction
  private static int findMaxInRow(int[][] grid, int width, int length) {
    int max = 1;
    
    for (int i = 0; i < length; i++) {
      max *= grid[0][i];
    }
    
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < width - length + 1; j++) {
        int temp = 1;
        
        for (int k = 0; k < length; k++) {
          temp *= grid[i][j + k];
        }
        
        if (temp > max) {
          max = temp;
        }
      }
    }
    
    return max;
  }
  
  // calculate the max product in up to down direction
  private static int findMaxInCol(int[][] grid, int width, int length) {
    int max = 1;
    
    for (int i = 0; i < length; i++) {
      max *= grid[0][i];
    }
    
    for (int i = 0; i < width - length + 1; i++) {
      for (int j = 0; j < width; j++) {
        int temp = 1;
        
        for (int k = 0; k < length; k++) {
          temp *= grid[i + k][j];
        }
        
        if (temp > max) {
          max = temp;
        }
      }
    }
    
    return max;
  }
  
  // calculate the max product in diagonal in top left to bottom right direction
  private static int findMaxInDiagonal(int[][] grid, int width, int length) {
    int max = 1;
    
    for (int i = 0; i < length; i++) {
      max *= grid[0][i];
    }
    
    for (int i = 0; i < width - length + 1; i++) {
      for (int j = 0; j < width - length + 1; j++) {
        int temp = 1;
        
        for (int k = 0; k < length; k++) {
          temp *= grid[i + k][j + k];
        }
        
        if (temp > max) {
          max = temp;
        }
      }
    }
    
    return max;
  }
  
  // calculate the max product in diagonal in bottom left to top right direction
  private static int findMaxInDiagonal2(int[][] grid, int width, int length) {
    int max = 1;
    
    for (int i = 0; i < length; i++) {
      max *= grid[0][i];
    }
    
    for (int i = width - 1; i > length - 2; i--) {
      for (int j = 0; j < width - length + 1; j++) {
        int temp = 1;
        
        for (int k = 0; k < length; k++) {
          temp *= grid[i - k][j + k];
        }
        
        if (temp > max) {
          max = temp;
        }
      }
    }
    
    return max;
  }
}