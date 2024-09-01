package exams.redbook;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/1 14:28
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l - 1 >= 0 && nums[l - 1] < nums[l]) l--;
            while (r + 1 < n && nums[r + 1] < nums[r]) r++;
            if (l != r) ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}
