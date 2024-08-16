package org.example;


import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @author wbq
 * @version 1.0
 * @title $NAME
 * @description
 * @create 2024/7/14 0:18
 */

public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
            e1.printStackTrace();
        }
    }
}