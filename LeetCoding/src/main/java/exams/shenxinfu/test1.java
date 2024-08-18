package exams.shenxinfu;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/18 19:33
 */

public class test1 {
    // note AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(), s = sc.nextLine();
        char[] ca = str.toCharArray(), sa = s.toCharArray();
        char command = '*';
        int pos = 0;
        for (int i = 0; i < sa.length && pos < ca.length; i++) {
            if (sa[i] == '*' && command == '*') break;     // hello motherfucker
            if (sa[i] == '*') {
                int j = i + 1, commandCnt = 0;
                while (j < sa.length && (sa[j] == command || sa[j] == '*')) {
                    if (sa[j] == command) commandCnt++;
                    j++;
                }
                int pathCnt = 0;
                while (pos < ca.length &&ca[pos] == command) {
                    pos++;
                    pathCnt++;
                }
                if (pathCnt < commandCnt) break;
                i = j - 1;
                continue;
            }
            command = sa[i];
            if (ca[pos] != command) break;
            pos++;
        }
        System.out.println(pos);
    }
}
