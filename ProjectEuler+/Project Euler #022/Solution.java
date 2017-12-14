import java.io.*;
import java.util.*;

public class Solution {

    private static int[] calcScore(String[] names) {
        int[] scoreArr = new int[names.length];

        for(int i = 0; i < names.length; ++i) {
            char[] charArr = names[i].toCharArray();
            int score = 0;
            for(int j = 0; j < charArr.length; ++j) {
                score += charArr[j] - 'A' + 1;
            }
            scoreArr[i] = score*(i+1);
        }

        return scoreArr;
    }

    private static int findPos(String[] names, String name) {
        for(int i = 0; i < names.length; ++i) {
            if(names[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] strArr = new String[num];

        for(int i = 0; i < num; ++i) {
            strArr[i] = in.next();
        }

        Arrays.sort(strArr);
        int[] scoreArr = calcScore(strArr);
        int query = in.nextInt();

        for(int i = 0; i < query; ++i) {
            System.out.println(scoreArr[findPos(strArr, in.next())]);
        }
    }
}
