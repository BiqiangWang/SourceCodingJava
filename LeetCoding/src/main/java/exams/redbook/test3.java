package exams.redbook;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/1 14:51
 */

public class test3 {
    // note accept 27%
    public static class UnionFind {
        private int[] parent;
        int[] size;
        public UnionFind(int n, char[] ca) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                if (ca[i] == 'B') size[i] = 1;
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
    }

    private static UnionFind uf;
    private static boolean[] vis;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String color = sc.nextLine();
        char[] ca = color.toCharArray();
        Set<Integer> redSet = new HashSet<>();
        for (int i = 0; i < ca.length; i++) if (ca[i] == 'R') redSet.add(i);
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            g[x].add(y);
            g[y].add(x);
        }
        int ans = 0;
        for (int red : redSet) {
            uf = new UnionFind(n, ca);
            vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (i == red || vis[i]) continue;
                vis[i] = true;
                dfs(i, g, red);
            }
            int mx = 0;
            for (int size : uf.size) mx = Math.max(mx, size);
            System.out.println(Arrays.toString(uf.size));
            ans = Math.max(ans, mx);
        }
        System.out.println(ans);
    }

    private static void dfs(int cur, List<Integer>[] g, int ban) {
        for (int next : g[cur]) {
            if (vis[next] || next == ban) continue;
            vis[next] = true;
            uf.union(cur, next);
            dfs(next, g, ban);
        }
    }
}
