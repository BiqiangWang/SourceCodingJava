package exams.wangyihuyu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/22 14:16
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] costs = new int[n], values = new int[n], nums = new int[n];
        for (int i = 0; i < n; i++) costs[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            values[i] = price - costs[i];
        }
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        // [val, nums]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{values[i], nums[i]});
        }
        long ans = 0;
        int tosold = k;
        while (tosold > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0], num = cur[1], sold = Math.min(num, tosold);
            if (val <= 0) break;
            tosold -= sold;
            ans += (long) val * sold;
            if (num - sold > 0) pq.offer(new int[]{val, num - sold});
        }
        System.out.println(ans);
    }
}
