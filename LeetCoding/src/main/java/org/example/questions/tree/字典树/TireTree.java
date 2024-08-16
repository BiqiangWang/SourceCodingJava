package org.example.questions.tree.字典树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wbq
 * @version 1.0
 * @title TireTree 字典树
 * @description
 * @create 2024/7/7 11:59
 */

public class TireTree {
    static class TireNode {
        Map<Character, TireNode> children = new HashMap<>();
        int cost = -1;
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
