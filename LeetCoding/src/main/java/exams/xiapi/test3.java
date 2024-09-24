package exams.xiapi;

import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/24 10:25
 */

public class test3 {
    public static void main(String[] args) {
        System.out.println(SumOfGreatestOddDivisor(4));
    }

    static long[] memo = new long[1000001];
    static long[] pre = new long[1000002];
    static {
        for (int i = 1; i < memo.length; i++) {
            memo[i] = f(i);
            pre[i] = pre[i - 1] + memo[i];
        }
    }

    private static long f(long n) {
        if (n % 2 == 1) return n;
        for (long i = (long) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0 && i % 2 == 1) return i;
        }
        return 1;
    }

    public static long SumOfGreatestOddDivisor(long n) {
        return pre[(int) n];
    }
}
