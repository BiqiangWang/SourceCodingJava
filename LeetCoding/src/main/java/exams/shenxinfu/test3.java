package exams.shenxinfu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/8/18 20:09
 */

public class test3 {
    public static class View {
        int tired;
        int happy;
        int x;
        int y;

        public View(int tired, int happy, int x, int y) {
            this.tired = tired;
            this.happy = happy;
            this.x = x;
            this.y = y;
        }
    }

    private static double ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        View[] views = new View[n];
        for (int i = 0; i < n; i++) {
            int tired = sc.nextInt(), happy = sc.nextInt();
            String s = sc.nextLine();
            String[] ss = s.substring(2, s.length() - 1).split(" ");
            int x = Integer.parseInt(ss[0]), y = Integer.parseInt(ss[1]);
            views[i] = new View(tired, happy, x, y);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int dis = Math.abs(views[i].x) + Math.abs(views[i].y);
            vis[i] = true;
            dfs(i, dis + views[i].tired, views[i].happy, vis, views, k - 1);
            vis[i] = false;
        }
        System.out.println(String.format("%.6f", ans));
    }

    private static void dfs(int cur, int tired, int happy, boolean[] vis, View[] views, int cnt) {
        if (cnt == 0) {
            int goHome = Math.abs(views[cur].x) + Math.abs(views[cur].y);
            ans = Math.max(ans, (double) happy / (tired + goHome));
            System.out.println("tired:" + tired + " happy:" + happy + " goHome:" + goHome + " ans:" + ans);
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            int dis = Math.abs(views[i].x - views[cur].x) + Math.abs(views[i].y - views[cur].y);
            dfs(i, tired + views[i].tired + dis, happy + views[i].happy, vis, views, cnt - 1);
            vis[i] = false;
        }
    }
}
