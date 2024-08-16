package exams.mihayou;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wbq
 * @version 1.0
 * @title task2
 * @description
 * @create 2024/8/3 20:49
 */

/**
3 100 2
15 19
20 30
15 19
1 2
2 3

ans
38

3 20 2
15 19
20 30
15 19
1 2
2 3

ans
30
*/

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[][] stones = new int[n][2];
        for (int i = 0; i < n; i++) {
            stones[i][0] = sc.nextInt();
            stones[i][1] = sc.nextInt();
        }
        Set<Integer>[] ban = new HashSet[n];
        Arrays.setAll(ban, i -> new HashSet<>());
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            ban[x].add(y);
            ban[y].add(x);
        }
//        int[][] dp = new int[m + 1][2];
//        for (int i = 0; i < n; i++) {
//            int weight = stones[i][0], val = stones[i][1];
//            for (int j = m; j >= weight; j--) {
//                // 判断二进制第 m 位是否为 1
//                if (dp[j - weight][1] >> j == 1) continue;
//                if (dp[j][0] < dp[j - weight][0] + val) {
//                    dp[j][0] = dp[j - weight][0] + val;
//                    dp[j][1] = dp[j - weight][1] | (1 << j);
//                }
//            }
//        }
//        System.out.println(dp[m][0]);
        // todo: dfs
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> curBan = new HashSet<>(ban[i]);
            ans = Math.max(ans, dfs(i, m - stones[i][0], stones[i][1], stones, curBan, ban));
        }
        System.out.println(ans);
    }

    private static int dfs(int cur, int leftSize, int val, int[][] stones, Set<Integer> curBan, Set<Integer>[] ban) {
        if (leftSize < 0) return 0;
        if (leftSize == 0 || cur == stones.length) {
            return val;
        }
        for (int next = cur + 1; next < stones.length; next++) {
            if (curBan.contains(next) || leftSize < stones[next][0]) continue;
            Set<Integer> newBan = new HashSet<>(curBan);
            newBan.addAll(ban[cur]);
            val = Math.max(val, dfs(next, leftSize - stones[next][0], val + stones[next][1], stones, newBan, ban));
        }
        return val;
    }
}
