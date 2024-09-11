package exams.wangyileihuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/11 14:33
 */

public class test3 {
    public static class Node implements Comparable<Node> {
        String name;
        int v1;
        int v2;

        public Node(String name, int v1, int v2) {
            this.name = name;
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public int compareTo(Node o) {
            return v1 - o.v1;
        }
    }
    private static final List<Node> list = new ArrayList<>();

    static {
        list.add(new Node("ace", 8, 4));
        list.add(new Node("bre", 2, 3));
        list.add(new Node("cat", 5, 2));
        list.add(new Node("dog", 1, 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String col = sc.next(), sort_type = sc.next();
        if (col.equals("sort1")) {
            if (sort_type.equals("asc")) {
                list.sort((Node o1, Node o2) -> o1.v1 - o2.v1);
            } else {
                list.sort((Node o1, Node o2) -> o2.v1 - o1.v1);
            }
        } else {
            if (sort_type.equals("asc")) {
                list.sort((Node o1, Node o2) -> o1.v2 - o2.v2);
            } else {
                list.sort((Node o1, Node o2) -> o2.v2 - o1.v2);
            }
        }
        for (Node node : list) {
            System.out.println(node.name + " " + node.v1 + " " + node.v2);
        }
    }
}
