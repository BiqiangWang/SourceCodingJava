package exams.lianxiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/3 14:45
 */

public class test2 {
    // note AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int[] weights = new int[m];
        for (int i = 0; i < m; i++) weights[i] = sc.nextInt();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Math.min(m, i + 1); j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + (long) nums[i] * weights[j]);
            }
        }
        for (long[] row : dp) System.out.println(Arrays.toString(row));
        System.out.println(dp[n][m]);
    }
}
