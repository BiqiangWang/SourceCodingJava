package exams.mihayou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title task3
 * @description
 * @create 2024/8/3 21:36
 */

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt();
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
                g[a].add(b);
                g[b].add(a);
            }
            int res = dfs(0, g, x);
            if (res == 0) System.out.println("Xiaoyo");
            else if (res == 1) System.out.println("Pyrmont");
            else System.out.println("Draw");
        }
    }

    private static int dfs(int cur, List<Integer>[] g, int x) {
        if (g[x].size() == 1) return cur;
        List<Integer> canChoose = new ArrayList<>();
        for (int i = 0; i < g.length; i++) {
            if (g[i].size() == 1) canChoose.add(i);
        }
        if (canChoose.isEmpty()) return -1;
        boolean win = false;
        for (int choose : canChoose) {
            int to = g[choose].get(0);
            g[choose].clear();
            int idx = getIndex(g[to], choose);
            g[to].remove(idx);
            int res = dfs(cur ^ 1, g, choose);
            if (res != -1) return res;
            if (res == cur) win = true;
            g[choose].add(to);
            g[to].add(choose);
        }
        return !win ? cur : cur ^ 1;
    }

    public static int getIndex(List<Integer> arr, int num) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == num) return i;
        }
        return -1;
    }
}
