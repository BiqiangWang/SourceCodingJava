package base.Sort;

/**
 * @author wbq
 * @version 1.0
 * @title QuickSort2   挖坑法，与第一种是不同的交换策略
 * @description
 * @create 2024/7/14 0:35
 */

public class QuickSort2 implements Sort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int key = partitionSort(arr, left, right);
        quickSort(arr, left, key - 1);
        quickSort(arr, key + 1, right);
    }


    // note: 这里是一种挖坑填坑的交换，与第一种方法的主要区别在于 基准值 的位置是否发生变动。
    private int partitionSort(int[] arr, int left, int right) {
        int key = arr[left];
        int pos = left;
        while (left < right) {
            while (left < right && arr[right] >= key) right--;
            swap(arr, pos, right);
            pos = right;
            while (left < right && arr[left] <= key) left++;
            swap(arr, left, pos);
            pos = left;
        }
        arr[pos] = key;
        return pos;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
