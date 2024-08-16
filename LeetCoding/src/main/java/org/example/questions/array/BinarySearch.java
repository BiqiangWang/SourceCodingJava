package org.example.questions.array;

/**
 * @author wbq
 * @version 1.0
 * @title BinarySearch
 * @description
 * @create 2024/4/26 10:20
 */

public class BinarySearch {
    // note: 使用 left = 0, right = n-1 是最常见的二分查找方法，适用于直接查找数组中的元素。
    // note: 使用 left = -1, right = n 更适用于查找边界条件，如第一个或最后一个满足特定条件的元素。
    /**
     *  二分查找需要注意三个关键：
     *  1. right的右半侧区间取值，决定了后续的写法
     *  2. while循环条件是否有等号
     *  3. 更改right和left的边界时，是否要+1和-1
     */

    // 能够找到具体数值
    public int findEqualPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 若找不到相等值，返回小于target的第一个值
    public int findLessPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 若找不到相等值，返回大于target的最后一个值
    public int findGreaterPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     *  当小于最小值时，返回 -1 ; 大于最大值时，返回 len
     */
    public int binarySearch(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return left;
    }
}
