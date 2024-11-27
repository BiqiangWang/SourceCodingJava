package exams.dianxing;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/11/9 9:27
 */

public class test2 {
    public static void main(String[] args) {
        String path = "/home/web/./tang/../miao/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> q = new ArrayDeque<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!q.isEmpty()) {
                    q.pollLast();
                }
            } else if (!paths[i].equals(".") && !paths[i].equals("")) {
                q.offerLast(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append("/").append(q.pollFirst());
        }
//        return sb.length() == 0 ? "/" : sb.toString();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < paths.length; i++) {
//            if (paths[i].equals("..")) {
//                if (sb.length() > 0) {
//                    sb.delete(sb.length() - 1, sb.length());
//                }
//            } else if (!paths[i].equals(".") && !paths[i].equals("")) {
//                sb.append("/").append(paths[i]);
//            }
//        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
