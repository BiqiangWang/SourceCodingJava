package org.example.questions.数位DP;

import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title 不含连续1的非负整数 leetcode-600
 * <a href="https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/description/">...</a>
 * @description
 * @create 2024/8/5 0:56
 */

public class 不含连续1的非负整数 {
    public static void main(String[] args) {
        System.out.println(findIntegers(5));
    }

    public static int findIntegers(int n) {
        char[] ca = Integer.toBinaryString(n).toCharArray();
        int[][] memo = new int[ca.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return func(0, false, true, ca, memo);
    }

    private static int func(int i, boolean pre1, boolean is_limit, char[] ca, int[][] memo) {
        if (i == ca.length) return 1;
        int up = is_limit ? ca[i] - '0' : 1;
        if (!is_limit && memo[i][pre1 ? 1 : 0] != -1) return memo[i][pre1 ? 1 : 0];
        int res = func(i + 1, false, is_limit && up == 0, ca, memo);
        if (!pre1 && up == 1) {
            res += func(i + 1, true, is_limit, ca, memo);
        }
        return memo[i][pre1 ? 1 : 0] = res;
    }
}
