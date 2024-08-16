package exams.yongyou;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt(), num = sc.nextInt();
        int ans = 1;
        if (num == 2) {
            System.out.println(1 > target);
        } else if (num == 3) {
            System.out.println(2 > target);
        } else if (num == 4) {
            ans = 4;
            System.out.println(ans > target);
        } else {
            while (num >= 5) {
                num -= 3;
                ans *= 3;
            }
            System.out.println(ans * num > target);
        }
    }
}