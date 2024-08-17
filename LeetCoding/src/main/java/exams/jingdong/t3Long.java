package exams.jingdong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title t3dp
 * @description
 * @create 2024/8/17 11:05
 */

public class t3Long {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt();
        sc.nextLine();
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1, cost = sc.nextInt();
            g[x].add(new int[] {y, cost});
        }
        long[][] memo = new long[n][a + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        long ans = dfs(0, 0, g, a, memo);
        if (ans < 20220201) {
            System.out.println(ans);
        } else {
            System.out.println("All roads lead to Home!");
            System.out.println(ans % 20220201);
        }
    }
    private static long dfs(int cur, int cost, List<int[]>[] g, int a, long[][] memo) {
        if (cost > a) return 0;
        if (cost == a && cur == g.length - 1) return 1;
        if (memo[cur][cost] != -1) return memo[cur][cost];
        long ans = 0;
        for (int[] next : g[cur]) {
            int y = next[0], pay = next[1];
            ans += dfs(y, cost + pay, g, a, memo);
        }
        return memo[cur][cost] = ans;
    }
}
