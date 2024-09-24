package exams.xiapi;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/24 10:20
 */

public class test2 {
    public static void main(String[] args) {

    }

    public int MaxCollectedWater(int[] road) {
        int n = road.length;
        int[] preMax = new int[n], afterMax = new int[n];
        preMax[0] = road[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], road[i]);
        }
        afterMax[n - 1] = road[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            afterMax[i] = Math.max(afterMax[i + 1], road[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], afterMax[i]) - road[i];
        }
        return ans;


    }
}
