package exams.baidu1;


import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/10/15 19:26
 */

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong(), k = sc.nextLong();
            if (k >= n) {
                System.out.println(1);
                continue;
            }
            long ans = 0;
            if  (k > 0) {
                long cha = n - k;
                if (n - cha * 2 > 0) {
                    ans = cha + 1;
                } else {
                    ans = k;
                }
            }
            System.out.println(ans);
        }
    }
}
