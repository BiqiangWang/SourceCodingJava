package exams.tecent;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test4
 * @description
 * @create 2024/8/23 20:05
 */

public class test4 {
    // AC
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String[] leaf = new String[]{"0", "10", "11"};
        int[] value = new int[]{2, 1, 2};
        TreeNode node = recoverHuffman(leaf, value);
        System.out.println(node.val);
    }

    public static class Pair {
        String str;
        TreeNode node;

        public Pair(String str, TreeNode node) {
            this.str = str;
            this.node = node;
        }
    }

    public static TreeNode recoverHuffman(String[] leaf, int[] value) {
        Map<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        TreeNode root = new TreeNode(0);
        for (String str : leaf) {
            TreeNode node = root;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    if (node.left == null) node.left = new TreeNode(0);
                    node = node.left;
                } else {
                    if (node.right == null) node.right = new TreeNode(0);
                    node = node.right;
                }
            }
            node.val = -1;  // 标识叶子节点
            PriorityQueue<Pair> pq =map.computeIfAbsent(str.length(), k -> new PriorityQueue<>(Comparator.comparing((Pair a) -> a.str)));
            pq.offer(new Pair(str, node));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : value) {
            pq.offer(v);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> b - a);
        for (int len : list) {
            PriorityQueue<Pair> q = map.get(len);
            while (!q.isEmpty()) {
                Pair p = q.poll();
                p.node.val = pq.poll();
            }
        }
        pushUp(root);
        return root;
    }

    private static int pushUp(TreeNode node) {
        if (node.val != 0) return node.val;
        node.val =  pushUp(node.left) + pushUp(node.right);
        return node.val;
    }
}
