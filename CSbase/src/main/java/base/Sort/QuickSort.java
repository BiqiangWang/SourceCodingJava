package base.Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public void quicksort(int[] arr, int left, int right) {
        if (left >= right) return;
        int key = partitionSort(arr, left, right);
        quicksort(arr, left, key - 1);
        quicksort(arr, key + 1, right);
    }

    public int partitionSort(int[] arr, int left, int right) {
        int key = left;
        while (left < right) {
            while (left < right && arr[right] >= arr[key]) right--;
            while (left < right && arr[left] <= arr[key]) left++;
            swap(arr, left, right);
        }
        swap(arr, left, key);
        return right;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
