import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wbq
 * @version 1.0
 * @title Main
 * @description
 * @create 2024/7/29 20:23
 */
public class Main {
    public static void main(String[] args) {
        String test = "HelloWorld";
        String a = "Hello";
        final String b = "World";
        System.out.println(test == "Hello" + "World");
        System.out.println(test == a + "World");   // 由于 a 不是 final，因此这不是在编译时计算，而是在运行时计算，生成了一个新对象
        System.out.println(test == "Hello" + b);
    }

    public static int findIntegers(int n) {
        char[] ca = Integer.toBinaryString(n).toCharArray();
        int[][] memo = new int[ca.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return func(0, false, true, ca, memo);
    }

    private static int func(int i, boolean pre1, boolean is_limit, char[] ca, int[][] memo) {
        if (i == ca.length) return 1;
        int up = is_limit ? ca[i] - '0' : 1;
        if (!is_limit && memo[i][pre1 ? 1 : 0] != -1) return memo[i][pre1 ? 1 : 0];
        int res = func(i + 1, false, is_limit && up == 0, ca, memo);
        if (!pre1 && up == 1) {
            res += func(i + 1, true, is_limit, ca, memo);
        }
        return memo[i][pre1 ? 1 : 0] = res;
    }
}
