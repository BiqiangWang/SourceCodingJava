package exams.shenxinfu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test4
 * @description
 * @create 2024/8/18 20:49
 */

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String strategy = sc.nextLine();
            String[] split = strategy.split(" ");
            String id = split[0], srcIp = split[1], srcPort = split[2], dstIp = split[3], dstPort = split[4], protocol = split[5];
        }
    }
}
