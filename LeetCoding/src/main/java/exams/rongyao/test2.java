package exams.rongyao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/21 19:13
 */

public class test2 {
    // note AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        String firstLine = sc.nextLine();
        String[] strs = firstLine.split(" ");
        int n = strs.length;
        int[][] grid = new int[m][n];
        for (int i = 0; i < n; i++) {
            grid[0][i] = Integer.parseInt(strs[i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
