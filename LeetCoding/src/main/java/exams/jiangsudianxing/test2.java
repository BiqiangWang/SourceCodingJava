package exams.jiangsudianxing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/22 10:26
 */

public class test2 {
    public static void main(String[] args) {
        // 最小编辑距离
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine(), b = sc.nextLine();
        char[] ca1 = a.toCharArray(), ca2 = b.toCharArray();
        int[][] dp = new int[ca1.length + 1][ca2.length + 1];
        for (int i = 1; i <= ca1.length; i++) dp[i][0] = i;
        for (int j = 1; j <= ca2.length; j++) dp[0][j] = j;
        for (int i = 1; i <= ca1.length; i++) {
            for (int j = 1; j <= ca2.length; j++) {
                if (ca1[i - 1] == ca2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
//        for (int[] row : dp) System.out.println(Arrays.toString(row));
        System.out.println(dp[ca1.length][ca2.length]);
    }
}
