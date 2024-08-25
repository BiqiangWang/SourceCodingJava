package exams.pdd;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/25 15:26
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] nums = new long[n];
            boolean hasOdd = false;
            int evenCnt = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextLong();
                if (nums[j] % 2 == 1) hasOdd = true;
                else evenCnt++;
            }
            System.out.println(MinOperations(nums, hasOdd, evenCnt));
        }
    }

    private static int MinOperations(long[] nums, boolean hasOdd, int evenCnt) {
        if (hasOdd) return evenCnt;
        // todo: 如果没有奇数，应该先找到能够 转化为奇数的最小操作次数
        int minOpTime = Integer.MAX_VALUE;
        for (long num : nums) {
            minOpTime = Math.min(minOpTime, getMinOpTime(num));
        }
        return minOpTime + evenCnt - 1;
    }

    private static int getMinOpTime(long num) {
        int times = 0;
        while (num % 2 == 0) {
            num /= 2;
            times++;
        }
        return times;
    }
}
