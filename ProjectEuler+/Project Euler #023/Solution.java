import java.io.*;
import java.util.*;

public class Solution {
  private static int sumOfDivisor(int num) {
    int sum = 1;
    int root = (int) Math.sqrt(num);

    // num is a square number
    if (root*root == num) {
      sum += root--;
    }

    for (int i = 2; i <= root; ++i) {
      if (num % i == 0) {
        sum += i + (num / i);
      }
    }

    return sum;
  }

  private static boolean isSplittable(int num, ArrayList<Integer> arr) {
    if (num > 20161) {
        return true;
    }

    for (Integer i : arr) {
      if (i >= num) {
        break;
      }

      for (Integer j : arr) {
        if (num - i < j) {
          break;
        } else if (num - i == j) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    ArrayList<Integer> abArr = new ArrayList<>();

    for (int i = 12; i < 20161; ++i) {
      if (sumOfDivisor(i) > i) {
          abArr.add(i);
      }
    }

    for (int i = 0; i < num; i++) {
      if (isSplittable(in.nextInt(), abArr)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
