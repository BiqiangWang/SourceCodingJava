package exams.oppo;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title exams.oppo.OPPO
 * @description
 * @create 2024/7/27 13:58
 */

public class OPPO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        outerLoop:
        while (caseNum-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n], b = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            // 判断第一行中，不同的个数
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (a[0][i] != b[0][i]) cnt++;
            }
            System.out.println(cnt);
            if (cnt * 2 > n) {  // 说明直接取反不是最优，应当先对第一行取反
                reverseRow(a, 0);
                ans++;
            }
            for (int i = 0; i < n; i++) {
                if (a[0][i] != b[0][i]) {
                    reverseCol(a, i);
                    ans++;
                }
            }
            for (int i = 1; i < n; i++) {
                if (isValid(a, b, i) < 0) {
                    System.out.println(-1);
                    continue outerLoop;
                } else if (isValid(a, b, i) == 1) {
                    reverseRow(a, i);
                    ans++;
                }
            }
            System.out.println(ans);


        }
    }

    private static void reverseRow(int[][] a, int row) {
        for (int i = 0; i < a.length; i++) {
            a[row][i] ^= 1;
        }
    }

    private static void reverseCol(int[][] a, int col) {
        for (int i = 0; i < a.length; i++) {
            a[i][col] ^= 1;
        }
    }

    private static int isValid(int[][] a, int[][] b, int row) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == b[i][0]) cnt++;
        }
        if (cnt == a.length) return 0;
        else if (cnt == 0) return 1;
        else return -1;
    }
}
