package exams.dewu;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/3 19:26
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
            int left = l;
            for (; left <= Math.min(r, l + n - 1); left++) {
                if (left % n == 0) break;
            }
            int right = left;
            while (right <= r) {
                right += n;
            }
            right -= n;
            if (right < left) {
                System.out.println(-1);
            } else {
                System.out.println(left / n + " " + right / n);
            }
        }
    }
}
