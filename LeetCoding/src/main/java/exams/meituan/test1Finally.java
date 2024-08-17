package exams.meituan;

/**
 * @author wbq
 * @version 1.0
 * @title Main
 * @description
 * @create 2024/8/17 20:29
 */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test1Finally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int k = n; k >= 2; k--) {
                if (isPrime(gcd(n, k))) {
                    System.out.println(k);
                    break;
                }
            }
        }
    }

    private static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}