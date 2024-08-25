package exams.pdd;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/25 15:01
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] v = new int[n];
            // 初始化v数组
            for (int j = 0; j < n; j++) {
                v[j] = sc.nextInt();
            }
            // 记录所有边的权重
            PriorityQueue<Integer> q = new PriorityQueue<>();
            long sumValue = v[0];
            for (int j = 0; j < n - 1; j++) {
                int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
                sumValue += w;
                q.offer(w);
            }
            System.out.println(getMaxValue(v, q, sumValue, sumValue));
        }
    }

    private static long getMaxValue(int[] v, PriorityQueue<Integer> q, long sumValue, long maxValue) {
        int n = q.size();
        for (int i = 0; i < n; i++) {
            int edge = q.poll();
            long dv = v[i + 1] - v[i];
            sumValue = sumValue - edge + dv;
            maxValue = Math.max(maxValue, sumValue);
        }
        return maxValue;
    }
}
