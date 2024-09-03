package exams.dewu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/3 19:32
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        char[] ca = s.toCharArray();
        int[] map = new int[26];
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n) {
                if (ca[j] == ca[i]) {
                    if (j - i + 1 == k) {
                        map[ca[i] - 'a'] += 1;
                        ans = Math.max(ans, map[ca[i] - 'a']);
                        i = j + 1;
                    }
                    j++;
                } else break;
            }
            i = j;
        }
        System.out.println(ans);
    }
}
