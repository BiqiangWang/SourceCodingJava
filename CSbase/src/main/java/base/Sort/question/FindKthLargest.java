package base.Sort.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbq
 * @version 1.0
 * @title k_th_large
 * @description
 * @create 2024/7/25 21:47
 */

public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr,k));
    }

    private static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 这是一个更简洁的 快速选择算法 实现
     * @param nums List<Integer>
     * @param k int
     * @return pivot 表示结果的值
     */
    private int quickSelect(List<Integer> nums, int k) {
        int pivot = nums.getFirst();
        List<Integer> larger = new ArrayList<>(), equal = new ArrayList<>(), small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) larger.add(num);
            else if (num == pivot) equal.add(num);
            else small.add(num);
        }
        if (k <= larger.size()) return quickSelect(larger, k);
        else if (larger.size() + equal.size() < k) return quickSelect(small, k - larger.size() - equal.size());
        else return pivot;
    }


    /**
     * 这个快速选择算法基于 快速排序的分区思想实现， 但是复杂度可能相对更高，在一些用例难以通过。
     * @param nums 原始数组
     * @param left 左边界
     * @param right 右边界
     * @param k 目标：第 k 大
     * @return 检索结果
     */
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pivot = partitionSort(nums, left, right);
        if (pivot == k) return nums[pivot];
        else if (pivot < k) return quickSelect(nums, pivot + 1, right, k);
        else return quickSelect(nums, left, pivot - 1, k);
    }

    private static int partitionSort(int[] nums, int left, int right) {
        int key = left;
        while (left < right) {
            while (left < right && nums[right] >= nums[key]) right--;
            while (left < right && nums[left] <= nums[key]) left++;
            swap(nums, left, right);
        }
        swap(nums, left, key);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
