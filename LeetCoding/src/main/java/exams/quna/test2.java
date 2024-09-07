package exams.quna;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/6 14:53
 */

public class test2 {
    private static int[] nums, b;
    private static long m = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[] nums = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        test2.nums = nums;
        test2.b = b;
        test2.m = m;
        int l = 1, r = nums.length;
        if (!checks(r)) System.out.println(-1);
        while (l < r) {
            int mid  = (l + r) >> 1;
            if (checks(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (r == nums.length && !checks(r)) System.out.println(-1);
        else System.out.println(r);
//        if (checks(r)) System.out.println(r);
//        else System.out.println(-1);
    }

    private static boolean checks(int len) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>(), q2 = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            q1.add(nums[i]);
            q2.add(b[i]);
        }
        long total = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            total += (long) q1.poll() * q2.poll();
        }
        return total >= m;
    }
}
