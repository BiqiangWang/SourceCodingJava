package exams.yongyou;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test4
 * @description
 * @create 2024/8/1 20:54
 */

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt();
        int[][] views = new int[n][3];
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < n; i++) {
                views[i][k] = sc.nextInt();
            }
        }
        Arrays.sort(views, Comparator.comparingInt(a -> a[1]));

    }
}
