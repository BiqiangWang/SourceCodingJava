package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author wbq
 * @version 1.0
 * @title Main
 * @description
 * @create 2023/10/29 20:43
 */
public class Main {
    public static void main(String[] args) {
        int[] citations = new int[]{100};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Integer[] cs = Arrays.stream(citations).boxed().sorted((a, b) -> b - a).toArray(Integer[]::new);
        if (cs[cs.length - 1] > cs.length) {
            return cs.length;
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] <= i + 1) {
                return Math.max(cs[i], i);
            }
        }
        return 0;
    }
}
