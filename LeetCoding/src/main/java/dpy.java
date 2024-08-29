import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wbq
 * @version 1.0
 * @title dpy
 * @description
 * @create 2024/8/28 20:31
 */

public class dpy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.close();

        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;

        Set<String>[] sets = new HashSet[n / 2 + 1];   // sets[i]保存长度为i的现有子串。
        Arrays.setAll(sets, i -> new HashSet<>());
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + p;
            for (int len = 1; len <= i / 2; len++) {
                String s = t.substring(i - len, i);
                if (sets[len].contains(s)) {
                    dp[i] = Math.min(dp[i], dp[i - len] + q);
                }
            }
            for (int len = 1; len <= i && len <= n / 2; len++) {
                String s = t.substring(i - len, i);
                sets[len].add(s);
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[n]);

    }
}
