package exams.oppo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title exams.oppo.OPPO3
 * @description
 * @create 2024/7/27 14:55
 */


/**
4
1 2 1
1 3 2
1 4 3
 */

public class OPPO3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] visited = new int[n];
        visited[0] = 1;
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            if (strs.length != 3) break;
            int x = Integer.parseInt(strs[0]) - 1, y = Integer.parseInt(strs[1]) - 1, val = Integer.parseInt(strs[2]);
            g[x].add(new int[]{y, val});
            g[y].add(new int[]{x, val});
        }
        System.out.println(dfs(0, visited, g, 0));
    }

    private static int dfs(int x, int[] visited, List<int[]>[] g, int val) {
        int ans = val;
        for (int[] e : g[x]) {
            int y = e[0], v = e[1];
            if (visited[y] == 2) continue;
            int index_xy = getIndex(g[x], y, v), index_yx = getIndex(g[y], x, v);;
            g[x].set(index_xy, new int[]{y, 0});
            g[y].set(index_yx, new int[]{x, 0});
            visited[y] += 1;
            ans = Math.max(ans, dfs(y, visited, g, val + v));
            g[x].set(index_xy, new int[]{y, v});
            g[y].set(index_yx, new int[]{x, v});
            visited[y] -= 1;
        }
        return ans;
    }

    private static int getIndex(List<int[]> path, int x, int v) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i)[0] == x && path.get(i)[1] == v) {
                return i;
            }
        }
        return -1;
    }
}
