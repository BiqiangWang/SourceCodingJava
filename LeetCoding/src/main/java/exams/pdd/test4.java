package exams.pdd;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test4
 * @description
 * @create 2024/8/25 16:21
 */

public class test4 {
    // note: accepted 32.5%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int ans = 0;
        while (true) {
            if (s.charAt(0) == '1') {
                int cnt = 0, i = 0;
                for (;i < s.length() - 1; i += 2) {
                    if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') cnt += 2;
                }
                if (i < s.length() && s.charAt(i) == '0') {
                    String s1 = reverse(s.substring(0, i + 1)), s2 = reverse(s.substring(i + 1));
                    s = s1 + s2;
                    continue;
                } else {
                    ans = Math.max(ans, cnt);
                    break;
                }
            }
            int pos = 0;
            while (pos < s.length() - 1) {
                if (s.charAt(pos) == s.charAt(pos + 1)) break;
                pos++;
            }
            ans = Math.max(ans, pos + 1);
            if (pos == s.length() - 1 || s.charAt(0) == s.charAt(s.length() - 1)) break;
            String s1 = reverse(s.substring(0, pos + 1)), s2 = reverse(s.substring(pos + 1));
            s = s1 + s2;
        }
        System.out.println(ans);
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
