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
        meituan.main();
    }

    public class dewu {
        private static void main() {
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

    public class jingdong {
        private static boolean isValid(int x, int y, int rows, int cols) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

        private static void main() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] grid = new int[2][n];
            for (int i = 0; i < 2; i++ ) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[2][n];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE / 2);
            }
            dp[1][n - 1] = grid[1][n - 1];
            for (int i = 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == 1 && j == n - 1) continue;
                    int right = Integer.MAX_VALUE / 2, down = Integer.MAX_VALUE / 2, up = Integer.MAX_VALUE / 2;
                    if (isValid(i, j + 1, 2, n)) {
                        right = dp[i][j + 1];
                    }
                    if (isValid(i + 1, j, 2, n)) {
                        down = dp[i + 1][j];
                    }
                    if (isValid(i - 1, j, 2, n)) {
                        up = dp[i - 1][j];
                    }
                    if ((i + j) % 2 == 0) {
                        int max = Math.max(Math.max(right, down), up);
                        dp[i][j] = grid[i][j] + max == Integer.MAX_VALUE / 2 ? 0 : max;
                    } else {
                        int min = Math.min(Math.min(right, down), up);
                        dp[i][j] = grid[i][j] + min == Integer.MAX_VALUE / 2 ? 0 : min;
                    }
                }
            }
            for (int[] row : dp) {
                System.out.println(Arrays.toString(row));
            }

        }
    }

    public class meituan {
        private static void main() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int l = 1, r = 200001;
            while (l < r) {
                int mid = (l + r) / 2;
                if (check(nums, mid, k)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println(r);
        }

        private static boolean check(int[] nums, int len, int k) {
            boolean[] vis = new boolean[200001];
            int cnt = 0;
            for (int num : nums) {
                for (int l = 1; l < len; l++) {
                    if (vis[num + l - 1]) continue;
                    vis[num + l - 1] = true;
                    cnt++;
                }
            }
            return cnt >= k;
        }
    }

}
