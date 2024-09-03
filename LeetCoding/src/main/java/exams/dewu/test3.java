package exams.dewu;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/3 19:55
 */

public class test3 {
    private static int target_x, target_y, ans = Integer.MAX_VALUE;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[m][n];
        int x = -1, y = -1;
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j) == 'W' ? -1 : 0;
                if (line.charAt(j) == 'B') {
                    x = i;
                    y = j;
                } else if (line.charAt(j) == '*') {
                    target_x = i;
                    target_y = j;
                }
            }
        }
        boolean[][] vis = new boolean[m][n];
        vis[x][y] = true;
        dfs(x, y, 3, 0, grid, vis);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int x, int y, int boom, int step, int[][] grid, boolean[][] vis) {
        if (x == target_x && y == target_y) {
            ans = Math.min(ans, step);
            return;
        }
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (!isValid(nx, ny, grid.length, grid[0].length) || vis[nx][ny]) continue;
            if (grid[nx][ny] == -1 && boom == 0) continue;
            vis[nx][ny] = true;
            if (grid[nx][ny] == -1) dfs(nx, ny, boom - 1, step + 2, grid, vis);
            else dfs(nx, ny, boom, step + 1, grid, vis);
            vis[nx][ny] = false;
        }
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
