package exams.quna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/6 14:19
 */

public class test1 {
    private static String ans = "";
    private static List<Integer> res = new ArrayList<>();
    private static int Len;

    public static void main(String[] args) {
        System.out.println((int) ' ');
        String[] arr = new String[]{"1", "2", "-1"};
        Arrays.sort(arr, (a, b) -> {
            return compare(a + b, b + a);
        });
        System.out.println(Arrays.toString(arr));



//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), len = 0;
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//            len += Integer.toString(nums[i]).length();
//        }
//        quickSort(nums, 0, n - 1);
//        for (Integer re : nums) {
//            System.out.print(re + " ");
//        }
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partitionSort(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    private static int partitionSort(int[] nums, int l, int r) {
        int key = l;
        while (l < r) {
            while (l < r && compare(Integer.toString(nums[key]), Integer.toString(nums[r])) <= 0) r--;
            while (l < r && compare(Integer.toString(nums[l]), Integer.toString(nums[key])) <= 0) l++;
            swap(nums, l, r);
        }
        swap(nums, l, key);
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    private static void dfs(int curLen, StringBuilder sb, int[] nums, boolean[] vis) {
//        if (curLen == Len) {
//            if (compare(sb.toString(), ans)) {
//                ans = sb.toString();
//            }
//            return;
//        }
//        if (sb.length() != 0 && !compare(sb.toString(), ans)) return;
//        for (int i = 0; i < nums.length; i++) {
//            if (vis[i]) continue;
//            vis[i] = true;
//            sb.append(nums[i]);
//            int appendLen = Integer.toString(nums[i]).length();
//            dfs(curLen + Integer.toString(nums[i]).length(), sb, nums, vis);
//            sb.delete(sb.length() - appendLen, sb.length());
//            vis[i] = false;
//        }
//    }

    private static void dfs2(int curLen, List<Integer> path, int[] nums, boolean[] vis) {
        if (curLen == Len) {
            if (compare(path, res)) {
                res = new ArrayList<>(path);
            }
            return;
        }
        if (!path.isEmpty() && !compare(path, res)) return;
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            path.add(nums[i]);
            dfs2(curLen + Integer.toString(nums[i]).length(), path, nums, vis);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }

    private static int compare(String x, String y) {
        for (int i = 0; i < Math.min(x.length(), y.length()); i++) {
            if (x.charAt(i) < y.charAt(i)) return -1;
            else if (x.charAt(i) > y.charAt(i)) return 1;
        }
        if (x.length() < y.length()) return -1;
        return 0;
    }

    private static boolean compare(List<Integer> l1, List<Integer> l2) {
        if (l2.isEmpty()) return true;
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int num : l1) sb1.append(num);
        for (int num : l2) sb2.append(num);
        return false;
//        return compare(sb1.toString(), sb2.toString());
    }

}
