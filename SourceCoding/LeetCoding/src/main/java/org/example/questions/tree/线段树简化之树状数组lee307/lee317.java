package org.example.questions.tree.线段树简化之树状数组lee307;

/**
 * @author wbq
 * @version 1.0
 * @title lee317
 * @description  参照题解中三叶的结论
 * @create 2023/11/14 9:07
 */

public class lee317 extends TreeShapeArray{
    int[] arr;
    int n;


    public lee317(int[] nums) {
        arr = nums;
        n = arr.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, arr[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - arr[index]);
        arr[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
