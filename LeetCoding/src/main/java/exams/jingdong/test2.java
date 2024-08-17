package exams.jingdong;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/17 10:26
 */

public class test2 {
    // note: AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        int[] a1 = new int[m], a2 = new int[n];
        for (int i = 0; i < m; i++) a1[i] = s1.charAt(i) - '0';
        for (int i = 0; i < n; i++) a2[i] = s2.charAt(i) - '0';

        // todo: 从S1中的第i个位置开始测试，判断此放置是否合法。
        int ans = a1.length + a2.length;
        outerLoop:
        for (int i = 0; i < m; i++) {
            // start from i in a1
            int pos1 = i;
            for (int pos2 = 0; pos2 < a2.length; pos2++, pos1++) {
                if (pos1 >= a1.length) break;
                if (a1[pos1] + a2[pos2] > 3) continue outerLoop;
            }
            ans = Math.min(ans, i + Math.max(a1.length - i, a2.length));
        }
        outerLoop:
        for (int i = 0; i < n; i++) {
            // start from i in a2
            int pos2 = i;
            for (int pos1 = 0; pos1 < a1.length; pos2++, pos1++) {
                if (pos2 >= a2.length) break;
                if (a1[pos1] + a2[pos2] > 3) continue outerLoop;
            }
            ans = Math.min(ans, i + Math.max(a1.length, a2.length - i));
        }
        System.out.println(ans);
    }
}
