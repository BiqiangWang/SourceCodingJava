package exams.xiapi;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/24 10:25
 */

public class test3t {
    public static void main(String[] args) {
        System.out.println(SumOfGreatestOddDivisor(3));
    }

    public static long SumOfGreatestOddDivisor(long n) {
        long ans = 0;
        while (n > 0) {
            long tmp = (n + 1) / 2;
            ans += tmp * tmp;
            n >>= 1;
        }
        return ans;
    }
}
