import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
      
    for (int i = 0; i < num; i++) {
      System.out.println(toWord(in.nextLong()));
    }
  }
    
      
  private static String toWord(long num) {
    if (num == 0) {
      return "Zero";
    }
    
    if (num / 1000000000 != 0) {
      if (num % 1000000 == 0) {
        return toWord3(num / 1000000000) + " Billion";
      } else {
        return toWord3(num / 1000000000) + " Billion " + toWord(num % 1000000000);
      }
    } else if (num / 1000000 != 0) {
      if (num % 1000000 == 0) {
        return toWord3(num / 1000000) + " Million";
      } else {
        return toWord3(num / 1000000) + " Million " + toWord(num % 1000000);
      }
    } else if (num / 1000 != 0) {
      if (num % 1000 == 0) {
        return toWord3(num / 1000) + " Thousand";
      } else {
        return toWord3(num / 1000) + " Thousand " + toWord(num % 1000);
      }
    } else {
      return toWord3(num);
    }
  }
  
  private static String toWord3(long num) {
    
    if (num < 10) {
      return toWord1(num);
    } else if (num < 100) {
      return toWord2(num);
    } else if (num % 100 == 0) {
      return toWord1(num / 100) + " Hundred";
    } else if (num % 100 < 10){
      return toWord1(num / 100) + " Hundred " + toWord1(num % 100);
    } else {
      return toWord1(num / 100) + " Hundred " + toWord2(num % 100);
    }
  }
  
  private static String toWord2(long num) {
    String str = "";
    
    HashMap<Long, String> teens = new HashMap<>();
    
    teens.put(10l, "Ten");
    teens.put(11l, "Eleven");
    teens.put(12l, "Twelve");
    teens.put(13l, "Thirteen");
    teens.put(14l, "Fourteen");
    teens.put(15l, "Fifteen");
    teens.put(16l, "Sixteen");
    teens.put(17l, "Seventeen");
    teens.put(18l, "Eighteen");
    teens.put(19l, "Nineteen");
    
    teens.put(20l, "Twenty");
    teens.put(30l, "Thirty");
    teens.put(40l, "Forty");
    teens.put(50l, "Fifty");
    teens.put(60l, "Sixty");
    teens.put(70l, "Seventy");
    teens.put(80l, "Eighty");
    teens.put(90l, "Ninety");
    
    if (teens.getOrDefault(num, null) != null) {
      return teens.get(num);
    } else {
      return toWord2(num - num % 10) + " " + toWord1(num % 10);
    }
  }
  
  private static String toWord1(long num) {
    HashMap<Long, String> ones = new HashMap<>();
    
    ones.put(1l, "One");
    ones.put(2l, "Two");
    ones.put(3l, "Three");
    ones.put(4l, "Four");
    ones.put(5l, "Five");
    ones.put(6l, "Six");
    ones.put(7l, "Seven");
    ones.put(8l, "Eight");
    ones.put(9l, "Nine");
    
    return ones.get(num);
  }
}