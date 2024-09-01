package exams.mayi;

/**
 * @author wbq
 * @version 1.0
 * @title test2
 * @description
 * @create 2024/9/1 20:40
 */

import java.util.*;

public class test2 {
    public static class Test {
        int l, r, size;
        Test left, right;
        public Test(int l, int r) {
            this.l = l;
            this.r = r;
            this.size = r - l;
        }
        public int update(int x) {
            if (x <= l || x >= r) return this.size;
            if (left != null) {
                this.size = Math.max(left.update(x), right.update(x));
            } else {
                left = new Test(l, x);
                right = new Test(x, r);
                this.size = Math.max(left.size, right.size);
            }
            return this.size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        Test test = new Test(1, n);
        for (int t = 0; t < q; t++) {
            int op = sc.nextInt(), x = sc.nextInt();
            if (op == 1) {
                test.update(x);
            } else {
                if (test.size >= x) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }
}