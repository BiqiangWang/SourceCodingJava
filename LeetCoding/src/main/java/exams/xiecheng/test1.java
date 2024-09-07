package exams.xiecheng;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/5 19:08
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        if (n == k) {
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
        } else if (k == 1) {
            for (int i = n; i > 0; i--) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = 1; i < k; i++) {
                System.out.print(i + " ");
            }
            for (int i = n; i >= k; i--) {
                System.out.print(i + " ");
            }
        }

    }
}
