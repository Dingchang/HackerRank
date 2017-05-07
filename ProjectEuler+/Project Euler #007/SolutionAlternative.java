import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionAlternative {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int[] arrPrime = nthPrime();
    
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      System.out.println(arrPrime[n - 1]);
    }
  }
  
  // create an array of the first 10000 primes
  private static int[] nthPrime() {
    int[] result = new int[10000];
    result[0] = 2;
    int count = 1;
    
    for (int i = 3; count < 10000; i += 2) {
      if (isPrime(i)) {
        result[count] = i;
        count++;
      }
    }
    
    return result;
  }
  
  // determine if a number is a prime number
  private static boolean isPrime(int n) {
    if (n == 2) {
      return true;
    }
    
    if (n % 2 == 0) {
      return false;
    }
    
    int limit = (int) Math.floor(Math.sqrt(n));
      
    for (int i = 3; i <= limit; i += 2) 
    {
      if (n % i == 0) 
        return false;
    }
    
    return true;
  }
}