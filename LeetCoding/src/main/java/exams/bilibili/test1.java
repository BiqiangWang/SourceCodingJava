package exams.bilibili;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/21 19:21
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int ans = 0, k = n / 2;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != str.charAt(i + k)) ans++;
        }
        System.out.println(ans);
    }
}
