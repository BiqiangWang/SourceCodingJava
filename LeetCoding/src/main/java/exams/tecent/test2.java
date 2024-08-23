package exams.tecent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/23 19:29
 */


public class test2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }

    public TreeNode makeCompleteTree (TreeNode root) {
        // write code here
        int depth = treeDepth(root);
        System.out.println(depth);
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curDep = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            curDep++;
            if (curDep < depth) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node.left == null) node.left = new TreeNode(1);
                    q.offer(node.left);
                    if (node.right == null) node.right = new TreeNode(1);
                    q.offer(node.right);
                }
            } else {
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.pollLast();
                    if (node.right != null) flag = true;
                    else if (node.right == null && flag) node.right = new TreeNode(1);
                    if (node.left != null) flag = true;
                    else if (node.left == null && flag) node.left = new TreeNode(1);
                }
            }
        }
        return root;

    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
