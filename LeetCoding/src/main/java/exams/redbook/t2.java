package exams.redbook;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title t2
 * @description
 * @create 2024/9/1 15:47
 */

public class t2 {
    // note accept 36%
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        ans = getValue(nums);
        int moveableCnt1 = 0, moveableCnt2 = 0;
        for (int i = 0; i < n; i++) {
            int moveable = sc.nextInt();
            if (moveable == 1) {
                if (nums[i] == 1) moveableCnt1++;
                else moveableCnt2++;
                nums[i] = 0;
            }
        }
        dfs(nums, moveableCnt1, moveableCnt2);
        System.out.println(ans);
    }

    private static void dfs(int[] nums, int moveableCnt1, int moveableCnt2) {
        if (moveableCnt1 + moveableCnt2 == 0) {
            if (getValue(nums) < ans) ans = getValue(nums);
            return;
        }
        int idx = 0;
        while(nums[idx] != 0) idx++;
        if (moveableCnt1 > 0) {
            nums[idx] = 1;
            dfs(nums, moveableCnt1 - 1, moveableCnt2);
            nums[idx] = 0;
        }
        if (moveableCnt2 > 0) {
            nums[idx] = 2;
            dfs(nums, moveableCnt1, moveableCnt2 - 1);
            nums[idx] = 0;
        }
    }

    private static int getValue(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) res += nums[i + 1] == nums[i] ? 0 : 1;
        return res;
    }
}
