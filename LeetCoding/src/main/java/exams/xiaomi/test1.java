package exams.xiaomi;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/19 16:33
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            int capacity = sc.nextInt(), n = sc.nextInt(), c = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int[] dp = new int[capacity + 1];
            for (int i = 0; i < n; i++) {
                for (int j = capacity; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            System.out.println(check(dp, c) ? "YES" : "NO");
        }
    }

    private static boolean check(int[] dp, int c) {
        for (int i = dp.length - 1; i >= dp.length - 1 - c; i--) {
            if (dp[i] == i) return true;
        }
        return false;
    }
}
