package exams.kedaxunfei;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title exams.feifan.fiefan
 * @description
 * @create 2024/7/6 19:47
 */

public class fiefan {
    /**
     * <a, b>
     *     自反性 -》 <a,a>
     *     对称性 -》 <a,b> = <b,a>
     *     传递性 -》 <a,c> = <a,b> && <b,c>
     *     m = 3
     *     (1,1) (2,2) (3,3) (1,2) (2,3)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Set<Integer>[] g = new HashSet[m];
        Arrays.setAll(g, i -> new HashSet<>());
        for (int k = 0; k < n; k++) {
            int a = in.nextInt(), b = in.nextInt();
            if (a == b) continue;
            g[b - 1].add(a - 1);
            for (int pre : g[a - 1]) {
                g[b - 1].add(pre);
            }
        }
        System.out.println(solve(g));
    }

    private static String solve(Set<Integer>[] g) {
        for (int i = 0; i < g.length; i++) {
            for (int pre : g[i]) {
                if (pre > i) continue;
                if (!g[pre].contains(i)) {
                    return "no";
                }
            }
        }
        return "yes";
    }

    public String getEncryptedString(String s, int k) {
        int n = s.length();
        k %= n;
        return s.substring(k) + s.substring(0, k);

    }


    private void test() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        Iterator<Integer> ketIt = map.keySet().iterator();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
