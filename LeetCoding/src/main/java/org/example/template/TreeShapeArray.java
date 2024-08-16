package org.example.template;

/**
 * @author wbq
 * @version 1.0
 * @title TreeShapeArray
 * @description  大部分线段树能解决的问题，树状数组都能做，但不是全部。且线段树的扩展性更好。
 * @create 2024/7/28 16:14
 */

public class TreeShapeArray {
    /**
     * note: 树状数组是对线段树的简化
     *  1. 树状数组是对线段树的简化，能够解决大部分线段树解决的问题，但不是全部，且扩展性相对更弱。
     *  2. 树状数组的核心在于lowbit方法，它的功能是返回一个数的二进制表示中最低位的1所对应的值。
     * note：
     *   - 单点修改x时，通过 +=lowbit(x)的方式，对所有的父节点进行修改。   树状数组的区间修改需要借助额外的<差分数组>来实现。
     *   - 单点查询x时，通过 -= lowbit(x)的方式，找到所有前置的相关节点。  区间查询转换为 两个单点查询之差即可。
     * case:
     *   - 个人感觉在需要 <区间修改> 的场景下就可以考虑线段树了
     * update time: 24/7/28
     */
    private int[] tree;

    public TreeShapeArray(int n) {
        tree = new int[n + 1];
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    private void add(int x, int val) {
        for (int i = x; i < tree.length; i += lowbit(i)) {
            tree[i] += val;
        }
    }

    private int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    private int rangeQuery(int l, int r) {
        return query(r + 1) - query(l);
    }

}
