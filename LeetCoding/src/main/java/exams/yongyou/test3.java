package exams.yongyou;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/8/1 19:36
 */

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt();
        }
        int maxStep = sc.nextInt();

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        g[0].add(1);
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maxStep && i + j < n; j++) {
                if (tasks[i + j] == -1) continue;
                if (dp[i] + tasks[i + j] < dp[i + j]) {
                    dp[i + j] = dp[i] + tasks[i + j];
                    g[i + j] = new ArrayList<>(g[i]);
                    g[i + j].add(i + j + 1);
                } else if (dp[i] + tasks[i + j] == dp[i + j]) {
                    boolean flag = false;
                    List<Integer> arr1 = g[i], arr2 = g[i + j].subList(0, g[i + j].size() - 1);
                    for (int k = 0; k < Math.min(arr1.size(), arr2.size()); k++) {
                        if (arr1.get(k) < arr2.get(k)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        g[i + j] = new ArrayList<>(g[i]);
                        g[i + j].add(i + j + 1);
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(dp[n - 1]);
        if (g[n - 1].isEmpty()) {
            System.out.println(g[n - 1]);
        } else {
            for (int num : g[n - 1]) {
                System.out.print(num + " ");
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(g[i]);
//        }
        
    }
}
