package org.example.questions.tree.线段树lee715;

/**
 * @author wbq
 * @version 1.0
 * @title SegmentTreeInterface
 * @description
 * @create 2023/11/12 14:10
 */

public interface SegmentTreeInterface {
    class Node {
        Node left, right;
        boolean cover;
        int add;
    }

    void pushDown(Node node, int leftNum, int rightNum);
    void pushUp(Node node, int leftNum, int rightNum);
    void update(Node node, int start, int end, int l, int r, int val);
    boolean query(Node node, int start, int end, int l, int r);
}
