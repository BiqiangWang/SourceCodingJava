package exams.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/17 19:19
 */

public class test1 {
    private static Set<Integer> set = new HashSet<>();

    static {
        outerLoop:
        for (int i = 2; i < 100000; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue outerLoop;
                }
            }
            set.add(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int k = n; k >= 0; k--) {
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
        if (n <= 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
