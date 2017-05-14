import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    long[] arr = collatzArr(6000000);
    int[] indexArr = longestArr(arr, 6000000);
    
    for (int i = 0; i < num; i++) {
      System.out.println(indexArr[in.nextInt()]);
    }
  }

  // create an array of int so that each value represent the number
  // that hase the longest collatz chain under its index
  private static int[] longestArr(long[] cArr, int limit) {
    int[] arr = new int[limit];
    arr[0] = 0;

    for (int i = 1; i < limit; i++) {
      if (cArr[i] >= cArr[arr[i - 1]]) {
        arr[i] = i;
      } else {
        arr[i] = arr[i - 1];
      }
    }

    return arr;
  }

  // create an array of long so that each value represent the collatz chain of its index
  private static long[] collatzArr(int limit) {
    long[] arr = new long[limit];
    arr[0] = 0l;

    for (long i = 1; i < limit; i++) {
      arr[(int)i] = findChain(i);
    }

    return arr;
  }

  // calculate the collatz chain of the given number
  private static long findChain(long num) {
    long count = 0l;

    while (num != 1) {
      if (num % 2 == 0) {
        num /= 2;
        count++;
      } else {
        num = 3 * num + 1;
        count++;
      }
    }

    return count;
  }
}