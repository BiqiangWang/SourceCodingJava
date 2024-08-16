package org.example.template;

/**
 * @author wbq
 * @version 1.0
 * @title 线段树
 * @description
 * @create 2024/8/10 0:57
 */

public interface SegmentTree线段树 {
    /**
     * note: 线段树适用于区间查询和动态修改的场景。并不局限于node节点的形式，完全可以通过一个数组来实现
     *  1. [1, N] 作为根节点root的搜索范围。
     *  2. 构建过程
     *  3. 查询过程
     * case 1: 使用简单的数组实现线段树  leetcode2940
     *  <a href="https://leetcode.cn/problems/find-building-where-alice-and-bob-can-meet/description/">...</a>
     *  构建时使用 build(o * 2, l, mid, heights) 和 build(o * 2 + 1, mid + 1, r, heights) 分别构建左右子树。o从根节点1开始
     * case 2： 使用复杂灵活的节点结构来实现，参照 segmentTree 中的示例
     * update time: 24/8/10
     */
    void SegmentTree线段树();

}
