package exams.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/5 19:22
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        char[] ca = line.toCharArray();
        int[] pre = new int[n];
        pre[0] = ca[0] == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + (ca[i] == ca[i - 1] ? 0 : 1);
        }
        int[] last0index = new int[n];
        last0index[0] = ca[0] == '0' ? 0 : -1;
        for (int i = 1; i < n; i++) {
            if (ca[i] == '0') {
                last0index[i] = i;
            } else {
                last0index[i] = last0index[i - 1];
            }
        }
        int ans = 0;
        for (int len = 1; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i++) {
                if (ca[i] == '0') {
                    ans++;
                } else {
                    int r = last0index[i + len - 1];
                    if (r > i && (pre[r] - pre[i]) % 2 == 0) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check2(char[] ca, int start, int len) {
        int i = start + len - 1, cnt = 0;
        char cur = '1';
        while (i >= start && ca[i] != '0') i--;
        while (i >= start) {
            if (ca[i] != cur) {
                cnt++;
                cur = ca[i];
            }
            i--;
        }
        return cnt % 2 == 1;
    }
}
