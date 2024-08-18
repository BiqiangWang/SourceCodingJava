package exams.shenxinfu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/18 19:56
 */

public class test2 {
    // note AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long ans = Long.MIN_VALUE;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = nums[i];
            ans = Math.max(ans, dp[i + 1]);
        }
        for (int i = k - 1; i < n; i++) {
            for (int j = 0; j <= i - k + 1; j++) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + nums[i]);
                ans = Math.max(ans, dp[i + 1]);
            }
        }
        System.out.println(ans);
    }
}
