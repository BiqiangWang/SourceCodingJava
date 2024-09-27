package exams.liantongruanyanyuan;


import java.util.HashMap;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/27 19:19
 */

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 输入数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 调用 （补全）delArr 方法，输出结果
        int result = delArr(nums);
        System.out.println(result);

        scanner.close();
    }

    private static int delArr(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean hasRepeat = false;
        int ans = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            if (map.get(num) == 2) {
                hasRepeat = true;
                ans += num;
            }
        }
        return hasRepeat ? ans : -1;
    }
}
