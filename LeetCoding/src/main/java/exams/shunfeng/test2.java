package exams.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/29 20:26
 */

public class test2 {
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        Arrays.sort(nums);
        boolean[] vis = new boolean[n];
        dfs(0, -1, nums, vis);
        System.out.println(ans);
    }

    private static void dfs(int cur, int pre, int[] nums, boolean[] vis) {
        if (cur == nums.length) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            if (pre == -1 || (nums[i] % pre == 0 || pre % nums[i] == 0)) {
                vis[i] = true;
                dfs(cur + 1, nums[i], nums, vis);
                vis[i] = false;
            }
        }
    }
}
