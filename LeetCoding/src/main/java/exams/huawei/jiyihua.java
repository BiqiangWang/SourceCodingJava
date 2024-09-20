package exams.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title jiyihua
 * @description
 * @create 2024/9/19 20:06
 */

public class jiyihua {
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
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
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int res = dfs(0, 0, nums, k, nums[0][0], memo);
        System.out.println(res);
    }


    private static int dfs(int x, int y, int[][] nums, int k, int max, int[][] memo) {
        if (k == 0) {
            if (x == nums.length - 1 && y == nums[0].length - 1) {
                return max;
            }
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (!isValid(nx, ny, nums.length, nums[0].length)) continue;
            res = Math.min(res, dfs(nx, ny, nums, k - 1, Math.max(max, nums[nx][ny]), memo));
        }
        return memo[x][y] = res;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
