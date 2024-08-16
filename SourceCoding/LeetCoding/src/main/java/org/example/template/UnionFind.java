package org.example.template;

/**
 * @author wbq
 * @version 1.0
 * @title 并查集模板
 * @leetcode
 *  middle 1631
 *  hard 2382
 * @description
 * @create 2023/12/11 20:48
 */
public class UnionFind {
    /**
     * note: args参数
     *   1. parent数组 表示每一个节点的连通块根节点。 初始状态都是自己。
     *   2. size数组 表示当前连通块的大小。但是注意 **只有根节点的size才是有效的**
     * note：func
     *   - find查找：根据 parent数组，找到当前节点x所在连通块的根节点。
     *   - union合并：若节点x和节点y不属于一个连通块，即 find(x) != find(y)，则对两个连通块的根节点进行合并，规则为size大的主导，size小的被合并
     *   - connected：判断两个节点是否属于同一个连通块
     * case:
     *   -
     * update time: 24/7/28
     */
    private int[] parent;
    private int[] size;

    UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) {
            return false;
        }
        if (size[px] > size[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[px] = py;
            size[py] += size[px];
        }
        return true;
    }

    private boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
