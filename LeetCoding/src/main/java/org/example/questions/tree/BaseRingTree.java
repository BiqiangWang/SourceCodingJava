package org.example.questions.tree;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author wbq
 * @version 1.0
 * @title BaseRringTree
 * @description 2127 内向基环树
 * @create 2023/11/1 14:27
 */
public class BaseRingTree {
    public static void main(String[] args) {
        int[] favorite = new int[]{1, 2, 0};
        System.out.println(maximumInvitations(favorite));
    }

    public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite) {
            deg[f]++;   // 统计基环树每个节点的入度
        }

        List<Integer>[] rg = new List[n];  // 反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {    // 拓扑排序，剪掉所有的树枝
            int x = q.poll();
            int y = favorite[x];
            rg[y].add(x);
            if (--deg[y] == 0) {
                q.add(y);
            }
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                continue;
            }
            // 遍历基环上的点
            deg[i] = 0;  // 避免重复访问
            int ringSize = 1;
            for (int x = favorite[i]; x != i; x = favorite[x]) {
                deg[x] = 0;
                ringSize++;
            }
            if (ringSize == 2) {
                sumChainSize = rdfs(i, rg) + rdfs(favorite[i], rg);
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(maxRingSize, sumChainSize);

    }

    public static int rdfs(int x, List<Integer>[] rg) {
        int maxDepth = 1;
        for (int son : rg[x]) {
            maxDepth = Math.max(maxDepth, rdfs(son, rg) + 1);
        }
        return maxDepth;
    }
}
