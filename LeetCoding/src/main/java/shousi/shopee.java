package shousi;


import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title shopee
 * @description
 * @create 2024/10/26 22:59
 */

public class shopee {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 22, 23, 21};
        int target = 24;
        findCombinations(nums, target, 0, new ArrayList<>());
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    private static void findCombinations(int[] nums, int target, int start, List<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            findCombinations(nums, target - nums[i], i + 1, path);
            path.removeLast();
        }
    }
}
