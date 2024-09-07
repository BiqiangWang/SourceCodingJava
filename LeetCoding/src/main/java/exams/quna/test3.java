package exams.quna;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/6 15:56
 */

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line  = sc.nextLine();
        char[] ca = line.toCharArray();
        System.out.println(dfs(0, 0, ca, 0));
    }

    private static int dfs(int cur, int pre, char[] ca, int cnt) {
        if (cur == ca.length) {
            if (checkForRound(pre, cur, ca)) {
                return cnt + 1;
            } else return 0;
        }
        int res = 0;
        if (checkForRound(pre, cur, ca)) {
            res += dfs(cur + 1, cur, ca, cnt + 1);
        }
        res += dfs(cur + 1, cur + 1, ca, cnt);
        return res;
    }

    private static boolean checkForRound(int start, int end, char[] ca) {
        return false;
    }
}
