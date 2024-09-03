package exams.lianxiang;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/3 14:25
 */

public class test1 {
    public static void main(String[] args) {
        // note AC
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), MOD = (int) 1e8 + 7, base = 1;
        long sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }
        while (!q.isEmpty()) {
            sum = (sum + pow(q.poll(), base, MOD)) % MOD;
            base++;
        }
        System.out.println(sum);
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        Arrays.sort(nums);
//        for (int i = 0; i < n; i++) {
//            sum = (sum + pow(nums[i], base, MOD)) % MOD;
//            base++;
//        }
//        System.out.println(sum);
    }

    private static long pow(long num, int base, int MOD) {
        while (base > 1) {
            if (base > 8) {
                num = (num * 128) % MOD;
                base -= 7;
            } else {
                num = (num * 2) % MOD;
                base--;
            }
        }
        return num;
    }
}
