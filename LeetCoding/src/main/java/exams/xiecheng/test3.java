package exams.xiecheng;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/5 20:14
 */

public class test3 {
    private static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int base = 1;
        for (int i = 0; i < m - 1; i++) base *= 10;
        K = k;
        boolean[] vis = new boolean[n + 1];
        System.out.println(func(0, base, vis));
    }

    private static int func(int cur, int base, boolean[] vis) {
        if (base == 0 ) {
            if (cur > K) return 1;
            return 0;
        }
        int res = 0;
        for (int i = 0; i < vis.length; i++) {
            if (cur == 0 && i == 0) continue;
            if (vis[i]) continue;
            vis[i] = true;
            res += func(cur + base * i, base / 10, vis);
            vis[i] = false;
        }
        return res;
    }
}
