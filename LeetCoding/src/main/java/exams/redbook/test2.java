package exams.redbook;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/1 14:34
 */

public class test2 {
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
        dfs(nums, moveableCnt1, moveableCnt2, 0, 0);
        System.out.println(ans);
    }

    private static int dfs(int[] nums, int moveableCnt1, int moveableCnt2, int cost, int cur) {
        if (moveableCnt1 + moveableCnt2 == 0) {
            return cost;
        }
        while (nums[cur] != 0) {
            cur++;
            if (nums[cur] != 0 && nums[cur] != nums[cur - 1]) cost++;
        }
        if (moveableCnt1 > 0) {
            nums[cur] = 1;
            if (cur > 0 && nums[cur] != nums[cur - 1]) cost++;
            dfs(nums, moveableCnt1 - 1, moveableCnt2, cost, cur);
            if (cur > 0 && nums[cur] != nums[cur - 1]) cost--;
            nums[cur] = 0;
        }
        if (moveableCnt2 > 0) {
            nums[cur] = 2;
            if (cur > 0 && nums[cur] != nums[cur - 1]) cost++;
            dfs(nums, moveableCnt1, moveableCnt2 - 1, cost, cur);
            if (cur > 0 && nums[cur] != nums[cur - 1]) cost--;
            nums[cur] = 0;
        }
        return cost;
    }

    private static int getValue(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) res += nums[i + 1] == nums[i] ? 0 : 1;
        return res;
    }
}
