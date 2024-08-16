package org.example.template;

/**
 * @author wbq
 * @version 1.0
 * @title 数位DP
 * @description
 * @create 2024/8/5 1:14
 */

public interface 数位DP<T> {
    /**
     * note 返回从 i 开始填数字，能够构造出的特殊整数的数量
     * @param mask 表示前面填的数字集合, 可以用一个int的二进制位来表示。
     * @param isLimit 表示前面填的数组是否都是n对应位置上的
     *          -如果为 true 那么当前位 至多为对应位置上的数，
     *          -否则可以是允许的最大值
     * @param isNum 表示前面是否填了数字（是否跳过），
     *          -如果为 true 那么当前位可以从0开始
     *          -如果为 false, 那么当前位可以 跳过，或从1开始填数字
     * note: 使用memo记忆化时，只需要对 i和mask进行记忆化即可。
     *              但是！！！需要注意在不受任何限制的情况下才能使用和更新memo数组！！！ 即：isLimit=false && isNum=true
     */
    T func(int i, int mask, boolean isLimit, boolean isNum);

    /**
     * 若前导零 对数字合法性没有影响，可以忽略isNum的判断
     */
    T func(int i, int mask, boolean isLimit);

    /**
     * 若不需要记录之前选取的数字，可以省略 mask
     */
    T func(int i, boolean isLimit, boolean isNum);
}
