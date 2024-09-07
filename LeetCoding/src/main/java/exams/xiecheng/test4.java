package exams.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test4
 * @description
 * @create 2024/9/5 20:50
 */

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), top = sc.nextInt(), sum = 0;
        int[] nums = new int[n];
        int[] sums = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            if (i - k + 1 >= 0) {
                sums[i - k + 1] = sum;
                sum -= nums[i - k + 1];
            }
        }
        System.out.println(Arrays.toString(sums));
        int ans = 0;
        for (int i = 0; i < sums.length; i++) {
            int op = 0;
            if (sums[i] > top) {
                op += sums[i] - top;
                sums[i + 1] -= op;
                sums[i + 2] -= op;
            }
            ans += op;
        }
        System.out.println(ans);

    }
}
