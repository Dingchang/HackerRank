import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    
    BigInteger sum = new BigInteger(in.next());
    
    while (in.hasNext()) {
      sum = sum.add(new BigInteger(in.next()));
    }
    
    while (sum.toString().length() != 10) {
      sum = sum.divide(new BigInteger("10"));
    }
    
    System.out.print(sum);
  }
}