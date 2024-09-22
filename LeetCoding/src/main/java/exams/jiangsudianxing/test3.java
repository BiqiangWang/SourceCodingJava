package exams.jiangsudianxing;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/22 10:44
 */

public class test3 {
    private static int ans = 0;
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        if (strs[0].equals("null")) {
            System.out.println(0);
            return;
        }
        Node root = new Node(Integer.parseInt(strs[0]));
        Deque<Node> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;
        while (idx < strs.length && !q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size && idx < strs.length; j++) {
                Node node = q.poll();
                if (strs[idx++].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new Node(Integer.parseInt(strs[idx - 1]));
                    q.offer(node.left);
                }
                if (idx == strs.length) break;
                if (strs[idx++].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new Node(Integer.parseInt(strs[idx - 1]));
                    q.offer(node.right);
                }
            }
        }
        if (root.left == null && root.right == null) {
            System.out.println(1);
        } else {
            dfs(root);
            if (root.val == 0) ans++;
            System.out.println(ans);
        }
//        bfs(root);
    }

    private static int dfs(Node root) {
        if (root.left == null && root.right == null) {
            root.val = 0;
            return 0;
        }
        int l = root.left == null ? 2 : dfs(root.left), r = root.right == null ? 2 : dfs(root.right);
        if (l == 1 || r == 1) {
            root.val = 2;
        } else if (l == 0 || r == 0) {
            root.val = 1;
            ans++;
        } else if (l == 2 && r == 2) {
            root.val = 0;
        }
        return root.val;
    }

    private static void bfs(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                System.out.print(node.val + " ");
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println();
        }
    }
}
