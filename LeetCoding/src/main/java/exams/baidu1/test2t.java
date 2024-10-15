package exams.baidu1;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test2t
 * @description
 * @create 2024/10/15 20:39
 */

public class test2t {
    // note AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder(line);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (ans.length() < line.length()) {
            if (i % 2 == 0) {
                sb.append(sb.charAt(i));
            } else {
                ans.append(sb.charAt(i));
            }
            i++;
        }
        System.out.println(ans);
    }
}
