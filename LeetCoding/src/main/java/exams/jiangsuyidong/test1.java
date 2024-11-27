package exams.jiangsuyidong;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/11/21 20:06
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int target = sum / nums.length, ans = 0;
        int target2 = sum / nums.length + 1, ans2 = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(Math.abs(nums[i] - target - 1), Math.abs(nums[i] - target + 1));
            ans2 += Math.min(Math.abs(nums[i] - target2 - 1), Math.abs(nums[i] - target2 + 1));
        }
        System.out.println(Math.min(ans, ans2));
    }
}
