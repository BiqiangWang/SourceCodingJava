package exams.wangyileihuo;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/11 14:27
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt() + 1, y = sc.nextInt() + 1;
        int gcd = gcd(x, y);
        x = x / gcd;
        y = y / gcd;
        System.out.println(gcd * func(x, y));
//        double k = (double) y / x, pre = 0;
//        int ans = 0;
//        for (int i = 1; i <= x; i++) {
//            double cur_y = k * i;
//            ans += (isInt(cur_y) ? (int) cur_y : (int) cur_y + 1) - (int) pre;
//            pre = cur_y;
//        }
//        System.out.println(ans);
    }

    private static boolean isInt(double num) {
        // fixed: 一定程度上修复精度导致的损失 return (num - (int) num) < 0.0000001;
        return num - (int) num == 0;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int func(int x, int y) {
        double k = (double) y / x, pre = 0;
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            double cur_y = k * i;
            ans += (isInt(cur_y) ? (int) cur_y : (int) cur_y + 1) - (int) pre;
            pre = cur_y;
        }
        return ans;
    }
}
