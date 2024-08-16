package exams.oppo;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title exams.oppo.OPPO
 * @description
 * @create 2024/7/27 13:58
 */

public class OPPO {
    /**
     * [11, 12, 11, 13, 12]
     * 12 = (1100), f(12) = (0011) = 3
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.merge(arr[i], 1, Integer::sum);
        }
        int min = Integer.MAX_VALUE, num = 0;
        for (int x : map.keySet()) {
            int val = x - reverseBit(x);
            if (val < min) {
                min = val;
                num = x;
            }
        }
        System.out.println(map.get(num));
    }

    private static int reverseBit(int num) {
        // 计算num的二进制位数
        int temp = num, len = 0;
        while (temp > 0) {
            len++;
            temp /= 2;
        }
        // 将num的每一位进行翻转，通过一个基准k来得到res
        int k = 1, res = 0;
        for (int i = 0; i < len; i++) {
            if ((num & 1) == 0) {
                res += k;
            }
            k *= 2;
            num /= 2;
        }
        return res;
    }
}
