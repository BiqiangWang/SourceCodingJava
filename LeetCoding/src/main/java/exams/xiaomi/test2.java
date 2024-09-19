package exams.xiaomi;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/19 16:40
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            int n = sc.nextInt();
            int[] a = new int[n], b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            // todo 分别做两种尝试，对于升序和降序
            boolean flag = false;
            int pre = -1;
            for (int i = 0; i < n; i++) {
                int mn = Math.min(a[i], b[i]), mx = Math.max(a[i], b[i]);
                if (mn >= pre) {
                    pre = mn;
                    if (i == n - 1) {
                        flag = true;
                    }
                } else if (mx >= pre) {
                    pre = mx;
                    if (i == n - 1) {
                        flag = true;
                    }
                } else {
                    break;
                }
            }
            pre = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int mn = Math.min(a[i], b[i]), mx = Math.max(a[i], b[i]);
                if (mx <= pre) {
                    pre = mx;
                    if (i == n - 1) {
                        flag = true;
                    }
                } else if (mn <= pre) {
                    pre = mn;
                    if (i == n - 1) {
                        flag = true;
                    }
                } else {
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
