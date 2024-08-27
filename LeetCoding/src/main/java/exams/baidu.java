package exams;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test
 * @description
 * @create 2024/8/26 15:30
 */

public class baidu {
    /**
     * case 9*9数独
     */
    private static List<int[][]> ans = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(random(9));
        Random random = new Random();
        System.out.println(random.nextInt(9));
//        func();
    }

    private static void func() {
        int[][] matrix = new int[9][9];
        Set<Integer>[] rowSet = new HashSet[9], colSet = new HashSet[9];
        Arrays.setAll(rowSet, i -> new HashSet<>());
        Arrays.setAll(colSet, i -> new HashSet<>());
        dfs(0, 0, rowSet, colSet, matrix);
    }

    private static void dfs(int i, int j, Set<Integer>[] rowSet, Set<Integer>[] colSet, int[][] matrix) {
        if (i >= 9) {
            ans.add(matrix);
//            System.out.println("----------------------------");
//            for (int[] row : matrix) {
//                System.out.println(Arrays.toString(row));
//            }
            return;
        }
        for (int k = 1; k < 10; k++) {
            if (rowSet[i].contains(k) || colSet[j].contains(k)) continue;
            rowSet[i].add(k);
            colSet[j].add(k);
            matrix[i][j] = k;
            int next_i = i + (j + 1) / 9, next_j = (j + 1) % 9;    // note 面试的时候bug在这
            dfs(next_i, next_j, rowSet, colSet, matrix);
            matrix[i][j] = 0;
            rowSet[i].remove(k);
            colSet[j].remove(k);
        }
    }

    private static int random(int max) {
        return (int) (Math.random() * max);
    }

}

/**
 * 1 8 6
 * 3 5 7
 * 4 2 9
 */
