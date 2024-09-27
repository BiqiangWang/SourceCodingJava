package exams.liantongruanyanyuan;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/27 18:27
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

        // 调用（补全）方法进行最大最小值交换
        swapMaxMin(nums, n);

        // 输出交换后的数组
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        scanner.close();
    }

    private static void swapMaxMin(int[] nums, int n) {
        int maxIdx = 0, minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        System.out.println(maxIdx + " " + minIdx);
        if (maxIdx == n - 1 && minIdx == 0) {
            swap(nums, 0, n - 1);
        } else {
            swap(nums, maxIdx, 0);
            swap(nums, minIdx, n - 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
