package exams.pdd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/8/25 15:36
 */

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] nums = new int[n], preMax = new int[n];
        Set<Integer> notValidPos = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (i > 0) preMax[i] = Math.max(preMax[i - 1], nums[i - 1]);
            if (nums[i] < preMax[i]) notValidPos.add(i);
        }
        int ans = 0, pos = nums.length - 1;
        boolean flag = true;
        while (pos >= 0 && !notValidPos.isEmpty()) {
            while (pos >= 0 && x <= nums[pos]) pos--;
            if (pos >= 0 && x > nums[pos]) {
                if (preMax[pos] > x) {
                    flag = false;
                    break;
                }
                int temp = nums[pos];
                nums[pos] = x;
                x = temp;
                ans++;
                notValidPos.remove(pos);
            }
        }
        System.out.println(flag ? ans : -1);
    }

    private static boolean isValid(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }
}
