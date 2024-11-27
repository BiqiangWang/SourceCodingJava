package exams.dianxing;


/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/11/9 9:25
 */

public class test1 {
    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
