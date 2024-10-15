package exams.baidu1;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/10/15 19:39
 */

public class test2 {
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder(line);
        String type = "even";
        while (sb.length() > 0) {
            String next_type = sb.length() % 2 == 0 ? "even" : "odd";
            sb = getSubString(sb, type);
            System.out.println(sb);
            type = next_type;
        }
        System.out.println(ans);
    }

    private static StringBuilder getSubString(StringBuilder sb, String type) {
        if (type.equals("even")) {
            int i = sb.length() - 1;
            if (i % 2 == 0) i--;
            Deque<Character> q = new ArrayDeque<>();
            while (i >= 0) {
                q.push(sb.charAt(i));
                sb.deleteCharAt(i);
                i -= 2;
            }
            while (!q.isEmpty()) {
                ans.append(q.pop());
            }
        } else {
            int i = sb.length() - 1;
            if (i % 2 == 1) i--;
            Deque<Character> q = new ArrayDeque<>();
            while (i >= 0) {
                q.push(sb.charAt(i));
                sb.deleteCharAt(i);
                i -= 2;
            }
            while (!q.isEmpty()) {
                ans.append(q.pop());
            }
        }
        return sb;
    }

    private static void original() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder(line);
        int n = line.length();
        for (int i = 0; i < n; i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            sb.append(c);
        }
        System.out.println(sb);
    }
}
