package exams.liantongshuke;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/10/18 19:46
 */

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组的大小
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 输入数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        double result = averageAfterRemovingMinMax(nums);
        System.out.printf("%.2f\n", result);
    }

    public static double averageAfterRemovingMinMax(int[] nums) {
        int max = nums[0], min = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        return (double) (sum - max - min) / (nums.length - 2);
    }
}
