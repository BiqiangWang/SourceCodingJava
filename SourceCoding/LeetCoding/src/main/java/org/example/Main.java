package org.example;


import java.sql.SQLOutput;
import java.util.*;
import java.util.function.BiFunction;

/**
 * @author wbq
 * @version 1.0
 * @title $NAME
 * @description
 * @create 2023/11/1 14:25
 */
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        //  function map
//        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
//        operations.put("+", Integer::sum);
//        operations.put("*", (x, y) -> x * y);
//        System.out.println(operations.get("+").apply(1, 2));
//        System.out.println(operations.get("*").apply(3, 4));
//        List<Character> list = Arrays.asList('(', '[', '{');
//        // hashset
//        Set<Character> set = new HashSet<>();
//        set.add('a');
//        set.add('b');
//        System.out.println(set.size());
//        Set<Integer> s = new TreeSet<>();
//        // queue
//        Deque<Integer> queue = new LinkedList<>();
//        //  优先队列 priority queue
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
//        priorityQueue.offer(new int[]{1, 2});
//        priorityQueue.offer(new int[]{1, 3});
//        System.out.println(priorityQueue.poll()[1]);
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.offer(1);
//        q.offer(2);
//        System.out.println(q.poll());
//
//        //
//        HashMap<Character, Integer> map = new HashMap<>();
//        Collection<Integer> values = map.values();
//        // sort
//        int[][] rides = new int[][]{};
//        Arrays.sort(rides, (x, y) -> x[0] - y[0]);
//
//        int[] arr = new int[]{1, 2, 3, 4};
//        System.out.println(Arrays.toString(arr));
//
//        List<Integer> a = new ArrayList<>();
//        a.add(5);
//        a.add(13);
//        a.add(7);
//        a.add(9);
//        int max = a.getLast();
//        for (int i = a.size() - 1; i >= 0; i--) {
//            if (a.get(i) > max) {
//                max = a.get(i);
//            } else {
//                a.set(i, max);
//            }
//        }
//
//        String date = "2019-01-09";
//        String[] ss = date.split("-");
//        int year = (int) Integer.parseInt(ss[0]);
//
//        String str = "123";
//        int aaa = Integer.parseInt(str);
//        String magazine = "aab";
//        for (char c : magazine.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        Set<String> set1 = new HashSet<>(List.of(ss));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(3);
        q.add(2);
        q.add(1);
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

        String title = "capiTalIze tHe titLe ";
        title.substring(0, title.length() -2);

    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (String w : word.split(String.valueOf(separator))) {
                ans.add(w);
            }
        }
        return ans;
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, count = t.length();
        int res_begin = 0, size = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                if (need.get(c) > 0) {
                    count--;
                }
                need.replace(c, need.get(c) - 1);
            }
            if (count == 0) {
                while (left < right && (!need.containsKey(s.charAt(left)) || (need.containsKey(s.charAt(left)) && need.get(s.charAt(left)) < 0))) {
                    if (need.containsKey(s.charAt(left))) {
                        need.put(s.charAt(left), need.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    res_begin = left;
                }
                if (need.containsKey(s.charAt(left))) {
                    need.put(s.charAt(left), need.get(s.charAt(left)) + 1);
                    left++;
                }
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(res_begin, res_begin + size);
    }

    public int[] computeMax(Deque<Integer> queue) {
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int num : queue) {
            if (num > max) {
                max = num;
                cnt = 1;
            } else if (num == max) {
                cnt++;
            }
        }
        return new int[]{max, cnt};
    }

    private static long findNextPalindrome(long num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        StringBuilder leftHalf = new StringBuilder(numStr.substring(0, length / 2 + length % 2));
        StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
        String palindromeStr = leftHalf.toString() + (length % 2 == 0 ? "" : rightHalf.charAt(0)) + rightHalf.toString();
        return Long.parseLong(palindromeStr);
    }
}