package exams.wangyihuyu;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/22 15:31
 */

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] nums = new long[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextLong();
            }
        }
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0] > 0 ? 1 : -1;
            } else {
                return a[1] - b[1] > 0 ? 1 : a[1] - b[1] == 0 ? 0 : -1;
            }
        });
        long ans = 0;
        int idx = 0;
        // 当前正在修炼的圣印
        PriorityQueue<long[]> cur =new PriorityQueue<>((a, b) -> a[2] - b[2] > 0 ? 1 : a[2] - b[2] == 0 ? 0 : -1);
        while (idx < n) {
            while (idx < n && nums[idx][0] < ans) {
                idx++;
            }
            while (idx < n && ans >= nums[idx][0] && ans <= nums[idx][1]) {
                cur.offer(nums[idx++]);
            }
            if (!cur.isEmpty()) {
                long[] xiulian = cur.poll();
                long gotExp = xiulian[3], timeCost = xiulian[2];
                ans += gotExp;
                Deque<long[]> q = new ArrayDeque<>();
                while (!cur.isEmpty()) {
                    long[] temp = cur.poll();
                    if (temp[2] == timeCost) {
                        ans += temp[3];
                        continue;
                    }
                    q.offer(temp);
                }
                while (!q.isEmpty()) {
                    long[] temp = q.poll();
                    if (ans >= temp[0] && ans <= temp[1]) {
                        temp[2] -= timeCost;
                        cur.offer(temp);
                    }
                }
            } else break;
        }
        System.out.println(ans);
    }
}
