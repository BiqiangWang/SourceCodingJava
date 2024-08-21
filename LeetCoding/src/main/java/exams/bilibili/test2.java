package exams.bilibili;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/8/21 19:24
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        char[] ca = str.toCharArray();
        Deque<Character> q = new LinkedList<>();
        int ans = -1;
        if (ca[0] == ')') {
            System.out.println(0);
        } else {
            q.push(ca[0]);
            for (int i = 1; i < n; i++) {
                if (ca[i] == '(') q.push(ca[i]);
                else {
                    if (!q.isEmpty()) {
                        q.pop();
                        if (q.isEmpty()) ans = i + 1;
                    } else break;
                }
            }
            System.out.println(ans == -1 ? n - q.size() : ans);
        }
    }
}
