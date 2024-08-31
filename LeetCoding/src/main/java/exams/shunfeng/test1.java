package exams.shunfeng;

import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/29 20:01
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            System.out.println(checkAndGet(str.toCharArray()));
        }
    }

    private static String checkAndGet(char[] ca) {
        int n = ca.length;
        if ((ca[0] >= 'A' && ca[0] <= 'Z') || (ca[n - 1] >= 'A' && ca[n - 1] <= 'Z')) {
            return "indistinct";
        }
        if (ca[0] == '_' || ca[n - 1] == '_') {
            return "indistinct";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ca[0]);
        int flag = 0;  // flag 标识哪种格式  1-驼峰； 2-下划线
        for (int i = 0 ; i < n - 1; i++) {
            if (ca[i] == '_' && (ca[i + 1] == '_' || (ca[i + 1] >= 'A' && ca[i + 1] <= 'Z'))) {
                return "indistinct";
            }
            if ((ca[i] >= 'A' && ca[i] <= 'Z') &&  (ca[i + 1] == '_' || (ca[i + 1] >= 'A' && ca[i + 1] <= 'Z'))) {
                return "indistinct";
            }
            if (ca[i] == '_') {
                if (flag == 0) flag = 2;
                else if (flag == 1) return "indistinct";
            }
            if (ca[i + 1] >= 'A' && ca[i + 1] <= 'Z') {
                if (flag == 0) flag = 1;
                else if (flag == 2) return "indistinct";
                sb.append("_");
                sb.append((char) (ca[i + 1] - 'A' + 'a'));
            } else {
                sb.append(ca[i + 1]);
            }
        }
        return sb.toString();
    }
}
