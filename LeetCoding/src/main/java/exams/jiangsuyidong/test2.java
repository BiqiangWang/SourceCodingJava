package exams.jiangsuyidong;


import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/11/21 20:16
 */

public class test2 {
    static int[] memo = new int[20];
    static Map<Integer, Integer> mmap = new HashMap<>();
    static {
        for (int i = 2; i < 20; i++) {
            memo[i] = memo[i - 1] + i - 1;
            mmap.put(memo[i], i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        List<int[]> points = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            for (int[] pos : points) {
                int a = pos[0], b = pos[1];
                double kk =  x - a != 0 ? (double) (y - b) / (x - a) : Double.MAX_VALUE;
                double bb = x == 0 ? y : a == 0 ? b :x - a != 0 ? (double) Math.abs(y * a - x * b) / (a - x) :
                    Double.MAX_VALUE;
                String key = kk + "," + bb;
                map.merge(key, 1, Integer::sum);
                int lines = map.get(key);
                try {
                    if (mmap.getOrDefault(lines, 0) == k) {
                        ans++;
                    }
                } catch (Exception e) {
                    System.out.println("errors when lines = " + lines);
                }
            }
            points.add(new int[]{x, y});
        }
        System.out.println(ans);
    }
}
