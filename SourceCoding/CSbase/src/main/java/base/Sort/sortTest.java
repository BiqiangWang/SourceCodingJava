package base.Sort;

import java.util.Arrays;

/**
 * @author wbq
 * @version 1.0
 * @title sortTest
 * @description
 * @create 2024/7/14 0:28
 */

public class sortTest {
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        // Note 快速排序
        int[] unsortedCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);
        new QuickSort2().sort(unsortedCopy);
        System.out.println(Arrays.toString(unsortedCopy));
    }
}
