package exams.fanruan;

import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/30 14:38
 */

public class test2 {
    private int[] nums1, nums2;
    private int k;
    private int[] ans;

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 9}, nums2 = {3, 1, 4};
        int k = 6;
        int[] ans = new test2().minNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] minNumber(int[] nums1, int[] nums2, int k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.k = k;
        this.ans = new int[k];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int[] path = new int[k];
        Arrays.fill(path, -1);
        int[][][] memo = new int[nums1.length + 1][nums2.length + 1][k + 1];
        for (int[][] mt : memo) {
            for (int[] row : mt) {
                Arrays.fill(row, -1);
            }
        }
        dfs(0, 0, path, 0);
        return ans;
    }

    private void dfs(int i, int j, int[] path, int cur) {
        if (cur == k) {
            for (int t = 0; t < k; t++) {
                if (path[t] < ans[t]) {
                    ans = update(path, ans);
                    break;
                } else if (path[t] > ans[t]) break;
            }
            return;
        }
        if (cur + (nums1.length - i) + (nums2.length - j) < k) return;
        if (cur == 0) {
            while (i < nums1.length && nums1[i] == 0) i++;
            while (j < nums2.length && nums2[j] == 0) j++;
        }
        if (i < nums1.length) {
            dfs(i + 1, j, path, cur);
            path[cur] = nums1[i];
            dfs(i + 1, j, path, cur + 1);
            path[cur] = -1;
        }
        if (j < nums2.length) {
            dfs(i, j + 1, path, cur);
            path[cur] = nums2[j];
            dfs(i, j + 1, path, cur + 1);
            path[cur] = -1;
        }
    }

    private boolean checkForUpdate(int[] path, int[] ans) {
        for (int i = 0; i < k; i++) {
            if (path[i] < ans[i]) return true;
        }
        return false;
    }

    private int[] update(int[] path, int[] ans) {
        for (int i = 0; i < k; i++) {
            ans[i] = path[i];
        }
        return ans;
    }
}
