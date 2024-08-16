package exams.mihayou;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title task1
 * @description
 * @create 2024/8/3 19:05
 */

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, (long) arr[i] * arr[i + 1]);
        }
        for (int i = 0; i < n - 2; i++) {
            ans = Math.max(ans, (long) arr[i] * arr[i + 2]);
        }
        System.out.println(ans);
    }
}
