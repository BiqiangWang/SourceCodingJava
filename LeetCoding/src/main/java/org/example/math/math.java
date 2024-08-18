package org.example.math;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author wbq
 * @version 1.0
 * @title math
 * @description
 * @create 2024/8/18 16:12
 */

public class math {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * note：最小公约数。辗转相除法即可。
     */
    private static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }

    /**
     * note: 判断是否为素数。遍历即可
     */
    private static boolean isPrime(int n) {
        if (n <= 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
