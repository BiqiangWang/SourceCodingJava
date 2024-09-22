package exams.jiangsudianxing;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/22 10:16
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] weights = new int[n], vals = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
        }
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + vals[i]);
            }
        }
        System.out.println(dp[target]);
    }
}
