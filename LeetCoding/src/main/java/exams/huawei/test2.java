package exams.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/19 19:42
 */

public class test2 {
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, nums, k, nums[0][0], new boolean[n][n]);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int[][] nums, int k, int max, boolean[][] vis) {
        int n = nums.length;
        if (k == 0) {
            if (x == n - 1 && y == n - 1) ans = max;
            return;
        }
        if (max >= ans || k < n * 2 - 2 - x - y) return;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n) || vis[nx][ny]) continue;
            vis[nx][ny] = true;
            dfs(nx, ny, nums, k - 1, Math.max(max, nums[nx][ny]), vis);
            vis[nx][ny] = false;
        }
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
