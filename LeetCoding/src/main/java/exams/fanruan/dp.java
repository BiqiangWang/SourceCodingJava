package exams.fanruan;

import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title dp
 * @description
 * @create 2024/8/30 15:23
 */

public class dp {
    public static void main(String[] args) {
        int[] dp = new int[15];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 15; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
    }
}
