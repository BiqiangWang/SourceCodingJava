package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title testForMyCode
 * @description
 * @create 2023/10/28 20:55
 */
public class testForMyCode {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        MyArrayList<String> list2 = new MyArrayList<>(list);
        System.out.println(list2);

        System.out.println(list2.toArray().getClass());

    }
}
