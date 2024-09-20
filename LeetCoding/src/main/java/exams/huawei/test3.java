package exams.huawei;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/19 20:30
 */

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), capacity = sc.nextInt();
        int[][] weights = new int[n][m];
        int[][] values = new int[n][m];
        for (int i = 0; i < n * m; i++) {
            int id = sc.nextInt();
            weights[id][i] = sc.nextInt();
            values[id][i] = sc.nextInt();
        }
        PriorityQueue<int[]> list = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int sumWeight = 0, sumValue = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, val = 0;
            for (int j = 0; j < m; j++) {
                if (weights[i][j] < min) {
                    if (min != Integer.MAX_VALUE) list.add(new int[]{min, val});
                    min = weights[i][j];
                    val = values[i][j];
                } else if (weights[i][j] == min) {
                    list.add(new int[]{min, Math.min(val, values[i][j])});
                    val = Math.max(val, values[i][j]);
                } else {
                    list.add(new int[]{weights[i][j], values[i][j]});
                }
            }
            sumWeight += min;
            sumValue += val;
        }
        if (sumWeight > capacity) {
            System.out.println(-1);
        } else {
            while (!list.isEmpty() && list.peek()[0] <= capacity) {
                sumValue += list.poll()[1];
            }
            System.out.println(sumValue);
        }
    }
}
