package exams.jiangsuyidong;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title t1
 * @description
 * @create 2024/11/21 20:59
 */

public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int target = Math.max(sum / nums.length - 5, 1); target <= Math.min(sum / nums.length + 5, 1000); target++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += nums[i] == target ? 0 : Math.min(Math.abs(nums[i] - target - 1), Math.abs(nums[i] - target + 1));
            }
            ans = Math.min(ans, temp);
        }
        System.out.println(ans);
    }
}
