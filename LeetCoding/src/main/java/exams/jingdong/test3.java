package exams.jingdong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/8/17 10:41
 */

public class test3 {
    // note: 60% accept. convert to long and use map graph is not useful, still stay at 60%
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
        int[][] memo = new int[n][a + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans = dfs(0, 0, g, a, memo);
        if (ans < 20220201) {
            System.out.println(ans);
        } else {
            System.out.println("All roads lead to Home!");
            System.out.println(ans % 20220201);
        }
    }
    private static int dfs(int cur, int cost, List<int[]>[] g, int a, int[][] memo) {
        if (cost > a) return 0;
        if (cost == a && cur == g.length - 1) return 1;
        if (memo[cur][cost] != -1) return memo[cur][cost];
        int ans = 0;
        for (int[] next : g[cur]) {
            int y = next[0], pay = next[1];
            ans += dfs(y, cost + pay, g, a, memo);
        }
        return memo[cur][cost] = ans;
    }
}