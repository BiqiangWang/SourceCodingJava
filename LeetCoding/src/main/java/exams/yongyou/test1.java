package exams.yongyou;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/1 19:04
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            if (arr[0].equals("-1")) {
                ans.add(i);
                continue;
            }
            for (String s : arr) {
                g[i].add(Integer.parseInt(s));
            }
        }
        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int next : g[i]) {
                if (!ans.contains(next)) continue outerLoop;
            }
            ans.add(i);
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

//    private static boolean dfs(int cur, List<Integer>[] g, boolean[] vis, int[] valid) {
//        if (valid[cur] == 1) return true;
//        if (valid[cur] == -1) return false;
//        vis[cur] = true;
//        boolean res = false;
//        for (int next : g[cur]) {
//            if (!vis[next]) {
//                if (!dfs(next, g, vis, valid)) return false;
//            }
//            res = true;
//        }
//        return res;
//    }
}
