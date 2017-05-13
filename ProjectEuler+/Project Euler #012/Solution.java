import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
          
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      System.out.println(divisorOver(n));
    }
  }
  
  // find the first triangular number that has more than limit divisors
  private static long divisorOver(int limit) {
    long tri = 1;
    long incriment = 1;
    int count = 0;
    int[] primeArr = primeArr(65535);
    
    while (count <= limit) {
      count = 1;
      incriment++;
      tri += incriment;
      long temp = tri;
      
      for (int i = 0; i < primeArr.length; i++) {
        if (primeArr[i] * primeArr[i] > temp) {
          count *= 2;
          break;
        }
        
        int exponent = 1;
        
        while (temp % primeArr[i] == 0) {
          exponent++;
          temp /= primeArr[i];
        }
        
        if (exponent > 1) {
          count *= exponent;
        }
        
        if (temp == 1) {
          break;
        }
      }
    }
    
    return tri;
  }
  
  // create an array of prime number by sieve of Eratosthenes
  private static int[] primeArr(int limit) {
    boolean[] primeArr = new boolean[limit];
    List<Integer> arr = new ArrayList<>();
    
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
    
    for (int i = 2; i < limit; i++) {
      if (primeArr[i]) {
        arr.add(i);
      }
    }
    
    int[] primes = new int[arr.size()];
    
    for (int i = 0; i < arr.size(); i++) {
      primes[i] = arr.get(i);
    }
    
    return primes;
  }
}