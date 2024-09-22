package exams.wangyihuyu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/22 14:44
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), times = sc.nextInt();
        long[] nums = new long[n];
        int[]leftMoveCnt = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (long) i * m + 1;
        }
        for (int i = 0; i < times; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt(), y = sc.nextInt();
                long tmp = nums[x - 1];
                nums[x - 1] = nums[y - 1];
                nums[y - 1] = tmp;
                int leftMoveTemp = leftMoveCnt[x - 1];
                leftMoveCnt[x - 1] = leftMoveCnt[y - 1];
                leftMoveCnt[y - 1] = leftMoveTemp;
            } else if (type == 2) {
                int x = sc.nextInt();
                long y = sc.nextLong();
                y %= m;
                leftMoveCnt[x - 1] =  (leftMoveCnt[x - 1] + (int) y) % m;
            } else {
                int x = sc.nextInt(), y = sc.nextInt();
                y = (y - 1 + leftMoveCnt[x - 1]) % m;
                System.out.println(nums[x - 1] + y);
            }
        }
    }
}
