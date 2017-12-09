import java.io.*;
import java.util.*;

public class Solution {

  private static boolean isSunday(long year, int month, int day) {
    if (month<3) {
      month += 12;
      year--;
    }

    return (day + 13 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 - 1) % 7 == 0;
  }

  private static void countSunday(long year1, int month1, int day1,
                                  long year2, int month2, int day2) {
    int count = 0;
    long currentYear  = year1;
    int  currentMonth = month1;

    if (day1 > 1) {
      currentMonth++;
      if (currentMonth > 12) {
        currentMonth -= 12;
        currentYear++;
      }
    }

    while (currentYear + 2800 < year2) {
      currentYear += 2800;
      count += 4816;
    }

    while (currentMonth < month2 || currentYear < year2) {
      if (isSunday(currentYear, currentMonth, 1)) {
        count++;
      }

      currentMonth++;

      if (currentMonth > 12) {
        currentMonth -= 12;
        currentYear++;
      }
    }

    if (isSunday(currentYear, currentMonth, 1)) {
      count++;
    }

    System.out.println(count);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    long year1, year2;
    int month1, month2, day1, day2;

    for (int i = 0; i < num; i++) {
      year1 = in.nextLong();
      month1 = in.nextInt();
      day1 = in.nextInt();
      year2 = in.nextLong();
      month2 = in.nextInt();
      day2 = in.nextInt();

      countSunday(year1, month1, day1, year2, month2, day2);
    }
  }
}
