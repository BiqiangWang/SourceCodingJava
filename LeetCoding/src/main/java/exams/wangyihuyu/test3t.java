package exams.wangyihuyu;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/22 15:31
 */

public class test3t {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        long ans = 0;
        int idx = 0;
        // 当前正在修炼的圣印
        PriorityQueue<int[]> cur =new PriorityQueue<>((a, b) -> a[2] - b[2]);
        while (idx < n) {
            while (idx < n && (nums[idx][1] < ans || nums[idx][0] > nums[idx][1])) {
                idx++;
            }
            while (idx < n && ans >= nums[idx][0] && ans <= nums[idx][1]) {
                cur.offer(nums[idx++]);
            }
            if (!cur.isEmpty()) {
                int[] xiulian = cur.poll();
                int gotExp = xiulian[3], timeCost = xiulian[2];
                ans += gotExp;
                while (!cur.isEmpty()) {
                    int[] temp = cur.poll();
                    if (temp[2] == timeCost) {
                        ans += temp[3];
                    } else break;
                }
                PriorityQueue<int[]> newCur =new PriorityQueue<>((a, b) -> a[2] - b[2]);
                while (!cur.isEmpty()) {
                    int[] temp = cur.poll();
                    if (ans >= temp[0] && ans <= temp[1]) {
                        temp[2] -= timeCost;
                        newCur.offer(temp);
                    }
                }
            } else break;
        }
        System.out.println(ans);
    }
}
