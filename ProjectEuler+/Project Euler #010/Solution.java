import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    long[] primeSumArr = primeSumArr(1000001);
          
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      System.out.println(primeSumArr[n]);
    }
  }
  
  // create an array of the sum of prime number under each number
  private static long[] primeSumArr(int limit) {
    boolean[] primeArr = primeArr(limit);
    long[] primeSumArr = new long[limit];
    primeSumArr[0] = 0;
    primeSumArr[1] = 0;
    
    for (int i = 2; i < limit; i++) {
      if (primeArr[i]) {
        primeSumArr[i] += i + primeSumArr[i - 1];
      } else {
        primeSumArr[i] += primeSumArr[i - 1];
      }
    }
    
    return primeSumArr;
  }
  
  // create an array of prime number determiner by sieve of Eratosthenes
  private static boolean[] primeArr(int limit) {
    boolean[] primeArr = new boolean[limit];
    Arrays.fill(primeArr, true);
    primeArr[0] = false;
    primeArr[1] = false;
    
    for (int i = 4; i < limit; i += 2) {
      primeArr[i] = false;
    }
    
    for (int i = 3; i * i <= limit; i += 2) {
      if (primeArr[i]) {
        for (int j = i * i; j < limit; j += 2 * i) {
          primeArr[j] = false;
        }
      }
    }
    
    return primeArr;
  }
}