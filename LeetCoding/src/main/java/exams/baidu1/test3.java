package exams.baidu1;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/10/15 19:48
 */

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), len = n, MOD = (int) 1e9 + 7;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n % 2 == 0) {
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) ans = (ans + nums[i]) % MOD;
                else ans = ans - nums[i] < 0 ? (ans - nums[i] + MOD) % MOD : (ans - nums[i]) % MOD;
            }
            System.out.println(ans);
        } else {
            if (n == 3) {
                System.out.println(nums[0] + nums[1] + nums[1] - nums[2]);
                return;
            }
            long ans = 0;
            for (int i = 0; i < n; i += 2) {
                ans = (ans + nums[i]) % MOD;
                if (i != n - 1 && i != 0) ans = (ans + nums[i]) % MOD;
            }
            System.out.println(ans);
        }
    }

    private static void original() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), len = n, MOD = (int) 1e9 + 7;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean plus = true;
        while (len > 0) {
            for (int i = 0; i < len - 1; i++) {
                if (plus) {
                    nums[i] = (nums[i] + nums[i + 1]) % MOD;
                } else {
                    nums[i] = (nums[i] - nums[i + 1] + MOD) % MOD;
                }
                plus = !plus;
            }
            len--;
        }
        System.out.println(nums[0]);
    }
}
