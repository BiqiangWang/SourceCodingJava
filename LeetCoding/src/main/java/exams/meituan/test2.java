package exams.meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/17 19:42
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int mid = (int) (sum / n);
        long sub = 0, inc = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > mid) {
                sub += nums[i] - mid - (sum % n == 0 ? 0 : 1);
            } else if (nums[i] < mid) {
                inc += mid - nums[i];
            }
        }
        if (sum % n == 0) System.out.println(sub);
        else System.out.println(Math.max(sub, inc));
    }
}
