package exams.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title kedaxunfei_test
 * @description
 * @create 2024/7/5 15:46
 */

public class kedaxunfei_test_24_pathch1 {
    public static void main(String[] args) {
        /**
         * 第二题
         */
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), q = sc.nextInt();
//        int[] pre = new int[n + 1];
//        sc.nextLine();
//        String s = sc.nextLine();
//        for (int i = 1; i < n; i++) {
//            if (s.charAt(i) == 'C' && s.charAt(i - 1) == 'A') pre[i + 1] = pre[i - 1] + 1;
//            else pre[i + 1] = pre[i];
//        }
//        for (int i = 0; i < q; i++) {
//            int l = sc.nextInt(), r = sc.nextInt();
//            System.out.println(pre[r] - pre[l]);
//        }
        /**
         * 第三题
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        System.out.println(Arrays.toString(pre));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, solve_hw3(arr, i, pre));
        }
        System.out.println(ans);
    }

    private static int solve_hw3(int[] arr, int pos, int[] pre) {
        int l_mid = pos / 2, r_mid = (arr.length - 1 + pos + 1) / 2;
        System.out.print("\nleft arr:");
        for (int i = 0; i <= pos; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nright arr:");
        for (int i = pos + 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nl_mid:" + l_mid + " r_mid:" + r_mid);
        int ll = arr[l_mid] * (l_mid + 1) - pre[l_mid + 1];
        int lr = pre[pos + 1] - pre[l_mid + 1] - arr[l_mid] * (pos - l_mid);
        System.out.println("ll:" + ll + " lr:" + lr);
        int rl = arr[r_mid] * (r_mid - pos) - (pre[r_mid + 1] - pre[pos + 1]);
        int rr = pre[arr.length] - pre[r_mid] - arr[r_mid] * (r_mid - pos);
        System.out.println(pre[arr.length] + " " + pre[r_mid] + " " + arr[r_mid] + " " + (pos - r_mid));
        System.out.println("rl:" + rl + " rr:" + rr);
        return ll + lr + rl + rr;
    }
}
