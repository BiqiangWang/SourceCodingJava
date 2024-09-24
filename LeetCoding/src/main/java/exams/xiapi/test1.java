package exams.xiapi;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/24 10:16
 */

public class test1 {
    public static void main(String[] args) {

    }

    public int FindSpecialUser(int n, int[][] relations) {
        int[] follower = new int[n], attention = new int[n];
        for (int[] r : relations) {
            int x = r[0] - 1, y = r[1] - 1;
            follower[y] += 1;
            attention[x] += 1;
        }
        for (int i = 0; i < n; i++) {
            if (follower[i] == n - 1 && attention[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
