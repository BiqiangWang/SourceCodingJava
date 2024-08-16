package org.example.questions.tree.线段树简化之树状数组lee307;

/**
 * @author wbq
 * @version 1.0
 * @title TreeShapeArrayInterface
 * @description   树状数组实现类，提供了最关键的三个函数
 * @create 2023/11/14 9:02
 */

public class TreeShapeArray {
    int[] tree;

    int lowbit(int x) {
        return x & (-x);
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    void add(int x, int val) {
        for (int i = x; i < tree.length; i += lowbit(i)) {
            tree[i] += val;
        }
    }
}
