package org.example.template;

/**
 * @author wbq
 * @version 1.0
 * @title 数位DP示例
 * @description
 * @create 2024/8/5 1:39
 */

public class 数位DP示例 implements 数位DP {
    int[] ca;

    /**
     * leetcode 2376 统计特殊整数
     * <a href="https://leetcode.cn/problems/count-special-integers/">...</a>
     */
    @Override
    public Object func(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == ca.length) return isNum ? 1 : 0;
        int res = 0;
        if (!isNum) res = (int) func(i + 1, mask, false, false);  // note 选择跳过，不填数字。这样是没有限制的。
        int up = isLimit ? ca[i] : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                res += (int) func(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        return res;
    }

    @Override
    public Object func(int i, int mask, boolean isLimit) {
        return null;
    }
    /**
     * leetcode 902 最大为n的数字组合
     * <a href="https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/">...</a>
     */
    @Override
    public Object func(int i, boolean isLimit, boolean isNum) {
        if (i == ca.length) return isNum ? 1 : 0;
        // if (!isLimit && isNum && memo[i] != -1) return memo[i];
        int res = 0;
        if (!isNum) res += (int) func(i + 1, false, false);
        int up = isLimit ? ca[i] - '0' : 9;
        for (int c : ca) {
            if (c > up) break;
            res += (int) func(i + 1, isLimit && c == up, true);
        }
        // if (!isLimit && isNum) memo[i] = res;
        return res;
    }
}
