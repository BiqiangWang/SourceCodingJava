package exams.rongyao;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/21 19:09
 */

public class test1 {
    // note AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(solve(str));
        }
    }

    private static String solve(String s) {
        if (s.length() % 2 == 1) return "false";
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return "false";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) return "false";
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
