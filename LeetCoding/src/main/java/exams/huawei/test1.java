package exams.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/19 19:02
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String[] express = new String[n];
        for (int i = 0; i < n; i++) {
            express[i] = sc.nextLine();
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            String key = words[0].trim(), val = words[1].trim();
            map.put(key, val);
        }
        for (String condition : express) {
            System.out.println(check(condition, map));
        }
    }

    private static boolean check(String condition, Map<String, String> map) {
        condition = condition.replace("AND", "&&")
            .replace("=", "==");
        String[] words = condition.split("&&");
        boolean correct = true;
        for (String word : words) {
            word = word.trim();
            boolean cur = false;
            if (word.charAt(0) == '(') word = word.substring(1, word.length() - 1);
            System.out.println(word);
            if (word.contains("OR")) {
                String[] cs = word.split("OR");
                for (String c : cs) {
                    String[] split = c.split("==");
                    String key = split[0].trim(), val = split[1].trim();
                    val = val.substring(1, val.length() - 1);
                    boolean tmp = map.get(key).equals(val);
                    if (tmp) {
                        cur = true;
                        break;
                    }
                }
            } else {
                String[] split = word.split("==");
                String key = split[0].trim(), val = split[1].trim();
                val = val.substring(1, val.length() - 1);
                cur = map.get(key).equals(val);
            }
            if (!cur) {
                correct = false;
                break;
            }
        }
        return correct;
    }
}
