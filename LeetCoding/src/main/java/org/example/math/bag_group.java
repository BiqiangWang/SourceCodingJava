package org.example.math;

import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title bag_group
 * @description
 * @create 2024/9/21 15:26
 */

public class bag_group {
    public static void main(String[] args) {
        int n = 2, capacity = 7, m = 2;
        int[][] weight = new int[][]{{3, 3}, {3, 3}}, val = new int[][]{{4, 4}, {2, 3}};
        System.out.println(minChooseOne(n, capacity, m, val, weight));
    }

    /**
     * case 分组背包 每组最多选一个
     */
    private static int maxChooseOne(int n, int capacity, int[] s, int[][] val, int[][] weight) {
        // n组物品，每组s[i]个，背包容量为capacity，weight 为物品重量，val 为物品价值
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            int[] w = weight[i], v = val[i];
            int si = s[i];
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];          // 不选。  note 若每组必须选一个，把这个不选的步骤删去即可
                for (int k = 0; k < si; k++) {
                    if (j >= w[k]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[k]] + v[k]);
                }
            }
        }
        return dp[n][capacity];
    }

    /**
     * case 分组背包，每组至少选1个
     */
    private static int minChooseOne(int n, int capacity, int m, int[][] val, int[][] weight) {
        int[] mn = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, weight[i][j]);
            }
            mn[i] = min;
        }
        int x = Arrays.stream(mn).sum();
        if (x > capacity) {
            System.out.println("Impossible");
            return -1;
        }
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int v = capacity; v >= weight[i - 1][j - 1]; v--) {
                    if (dp[i][v - weight[i - 1][j - 1]] != -1) {    // 从本组里面取，之前可能抽取了多个
                        dp[i][v] = Math.max(dp[i][v], dp[i][v - weight[i - 1][j - 1]] + val[i - 1][j - 1]);
                    }
                    if (dp[i - 1][v - weight[i - 1][j - 1]] != -1) {  // 当前是从本组中抽取的第一个
                        dp[i][v] = Math.max(dp[i][v],dp[i - 1][v - weight[i - 1][j - 1]] + val[i - 1][j - 1]);
                    }
                }
            }
        }
        return dp[n][capacity];
    }
}
