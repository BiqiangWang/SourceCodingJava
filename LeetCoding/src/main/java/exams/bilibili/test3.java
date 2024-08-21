package exams.bilibili;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/8/21 19:39
 */

public class test3 {
    private static int[] nums;
    private static long m = -1;
    private static long ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next() , s2 = sc.next();
        long n = Long.parseLong(s1), m = Long.parseLong(s2);
        String str = Long.toString(n);
        int[] nums = new int[str.length()];
        test3.nums = nums;
        test3.m = m;
        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }
        boolean[] vis = new boolean[str.length()];
        dfs(str.length() - 1, 0, vis);
        System.out.println(ans);
    }

    private static void dfs(int cur, long num, boolean[] vis) {
        if (cur == -1) {
            if (num % m == 0) ans++;
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (cur == vis.length - 1 && nums[i] == 0) continue;
            if (vis[i]) continue;
            vis[i] = true;
            dfs(cur - 1, num + getNum(cur - 1, nums[i]), vis);
            vis[i] = false;
        }
    }

    private static long getNum(int pass, long base) {
        while (pass-- > 0) {
            base *= 10;
        }
        return base;
    }
}
