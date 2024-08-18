package org.example.math;

/**
 * @author wbq
 * @version 1.0
 * @title bag
 * @description 背包问题总结
 * @create 2024/8/18 16:42
 */

public class bag {
    /**
     * note 递推公式
     *      1. 问能否装满或最多装多少： dp[j] = max(dp[j], dp[j - weight] + value);
     *      2. 问装满有几种方法： dp[j] += dp[j - weight];
     *      3. 问装满的最大价值： dp[j] = max(dp[j], dp[j - weight] + value);
     *      4. 问题装满背包的最少物品数： dp[j] = min(dp[j], dp[j - weight] + 1);
     * note 遍历顺序
     *      case 01背包
     *          1. 二维dp中先遍历物品还是先遍历背包都可以。
     *          2. 一维dp中，只能先遍历物品再遍历背包，
     *          note 需要注意的共性问题是，二层遍历背包时需要反向遍历。因为01背包只能选一次，同理完全背包正向遍历即可。
     *      case 完全背包
     *          1. 求组合数：先外层遍历物品，再内层遍历背包。
     *          2. 求排列数：先遍历背包，再遍历物品。
     * <a href="https://programmercarl.com/%E8%83%8C%E5%8C%85%E6%80%BB%E7%BB%93%E7%AF%87.html#%E6%80%BB%E7%BB%93">题目可参考代码随想录</a>
     */
    public static void main(String[] args) {
        System.out.println("hello world!");
    }

}
