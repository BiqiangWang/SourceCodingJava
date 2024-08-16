package org.example.template;

/**
 * @author wbq
 * @version 1.0
 * @title SegmentTree
 * @description  线段树： 主要解决的是「区间和」的问题，且该「区间」会被修改
 * @create 2023/11/12 13:48
 */

public class SegmentTree{
    /**
     * note: 线段树要点
     *  1. [1, N] 作为根节点root的搜索范围。
     *  2. 构建过程：更新方法虽然参数较多但本质上 root, start, end 是固定的，对外可以重载一个更简单的update方法，只包含l,r,val即可
     *  3. 查询过程：与构建过程类似，重载一个query方法
     * note：
     *   - 重点在于动态开点，在插入和查询过程中，若当前节点不完全在 要求区间[l,r]内，需要进行动态开点。   动态开点在 pushDown 方法中进行实现。
     *   - 还需要注意的是： pushDown之后的pushUp操作
     * case:
     *   - 在具体应用中，需要根据具体场景 修改pushDown中的val更新策略，以及pushUp中的val更新策略
     * update time: 24/7/28
     */
    static class Node {
        Node left, right;
        int val;
        int add;  // 懒惰标记
    }
    private final int N = (int) 1e9;
    private Node root = new Node();

    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        // 注意：当前节点加上标记值✖️该子树所有叶子节点的数量
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 把标记下推给孩子节点
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    private void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            // 区间节点加上更新值
            // 注意：需要✖️该子树所有叶子节点
            node.val += val * (end - start + 1);
            node.add += val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pushUp(node);
    }

    private int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        int ans = 0;
        if (l <= mid) {
            ans += query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans += query(node.right, mid + 1, end, l, r);
        }
        return ans;
    }
}
