package exams.fanruan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/30 14:19
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(longestPalindromeSubseqDP(s));
    }

    public static int longestPalindromeSubseqDP(String s) {
        char[] ca = s.toCharArray();
        int n = ca.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (ca[i] == ca[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(0, s.length() - 1, s.toCharArray(), memo);
    }

    private static int dfs(int i, int j, char[] ca, int[][] memo) {
        if (i == j) return 1;
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (ca[i] == ca[j]) return dfs(i + 1, j - 1, ca, memo) + 2;
        return Math.max(dfs(i + 1, j, ca, memo), dfs(i, j - 1, ca, memo));
    }
}
