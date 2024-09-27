package exams.liantongruanyanyuan;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/27 19:14
 */

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 输入数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 输入目标值
        int target = scanner.nextInt();

        // 调用（补全）三数之和最近的函数
        int result = threeSumClosest(nums, target);

        // 输出结果
        System.out.printf("%d",result);

        scanner.close();
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) right--;
                else if (sum < target) left++;
                else return ans;
            }
        }
        return ans;
    }
}
