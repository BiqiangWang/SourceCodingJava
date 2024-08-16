package org.example.template;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wbq
 * @version 1.0
 * @title TireTree 字典树（前缀树）
 * @description  通过利用字符串的公共前缀来节约存储空间，主要用于统计、排序和保存大量的字符串
 * @create 2024/7/7 11:59
 */

public class TireTree {
    /**
     * note: 字典树要点
     *  1. children的结构，通常情况下可以用map，若是针对小写字母，可以直接优化成一个长度为26的TrieNode数组
     *  2. 需要一个标志位表示当前节点是否为最后一个节点。这里的示例为了更好的扩展性，将其设置为数值-1，这样允许设置每个字典的分数/开销。
     * note：
     *   - 字典树本身思路并不复杂。需要结合具体场景使用。
     * case:
     *   -
     * update time: 24/7/28
     */
    static class TireNode {
        Map<Character, TireNode> children = new HashMap<>();
        int cost = -1;
    }

    private TireNode root = new TireNode();


    private void insert(String str, int cost) {
        TireNode node = root;
        for (char c : str.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TireNode());
        }
        if (node.cost == -1 || node.cost > cost) {   // 如果还没有这个字典或原字典的开销比当前更大，则更新节点
            node.cost = cost;
        }
    }

    private int getCost(String str) {
        TireNode node = root;
        for (char c : str.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return -1;
            }
        }
        return node.cost;
    }


    public int minCostLeetcodeWeek405(String target, String[] words, int[] costs) {
        TireNode root = new TireNode();
        for (int i = 0; i < words.length; i++) {
            TireNode node = root;
            for (char c : words[i].toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TireNode());
            }
            if (node.cost == -1 || node.cost > costs[i]) {
                node.cost = costs[i];
            }
        }
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            TireNode node = root;
            for (int j = 0; j < n; j++) {
                node = node.children.get(target.charAt(j));
                if (node == null) break;
                if (node.cost != -1) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + node.cost);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
