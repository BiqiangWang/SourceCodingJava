package org.example.questions.tree.线段树lee715;

/**
 * @author wbq
 * @version 1.0
 * @title lee715
 * @description
 * @tutorial <a href="https://leetcode.cn/problems/range-module/solutions/1612955/by-lfool-eo50/">详解教程</a>
 * @create 2023/11/12 14:08
 */

public class lee715 implements SegmentTreeInterface{

    @Override
    public void pushDown(Node node, int leftNum, int rightNum) {
        // 动态开点
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        // 如果 add 为 0，表示没有标记
        if (node.add == 0) {
            return;
        }
        node.left.cover = node.add == 1;
        node.right.cover = node.add == 1;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    @Override
    public void pushUp(Node node, int leftNum, int rightNum) {
        node.cover = node.left.cover && node.right.cover;
    }

    @Override
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.cover = val == 1;
            node.add = val;
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
        pushUp(node, mid -start + 1, end - mid);
    }

    @Override
    public boolean query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.cover;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        boolean ans = true;
        if (l <= mid) {
            ans &= query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans &= query(node.right, mid + 1, end, l, r);
        }
        return ans;
    }
}
