package exams.kedaxunfei;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title kedaxunfei_test
 * @description
 * @create 2024/7/5 15:46
 */

public class kedaxunfei_test_23 {
    static final int NUM_TEAMS = 5;
    static final int NUM_MATCHES = 10;
    static final int[] points = {3, 0, 1}; // 胜者得分、负者得分、平局得分

    public static void main(String[] args) {
        List<int[]> matches = generateMatches();
        Set<String> uniqueScores = new HashSet<>();
        for (int[] matchResult : matches) {
            int[] scores = new int[NUM_TEAMS];
            for (int i = 0; i < NUM_MATCHES; i++) {
                // fixme
                int team1 = i % NUM_TEAMS;
                int team2 = (team1 + (i >= NUM_TEAMS ? 1 : -1) + NUM_TEAMS) % NUM_TEAMS;
                if (matchResult[i] == 0) { // team1 胜
                    scores[team1] += points[0];
                    scores[team2] += points[1];
                } else if (matchResult[i] == 1) { // team2 胜
                    scores[team1] += points[1];
                    scores[team2] += points[0];
                } else { // 平局
                    scores[team1] += points[2];
                    scores[team2] += points[2];
                }
            }
            Arrays.sort(scores);
            uniqueScores.add(Arrays.toString(scores));
        }
        System.out.println("Total unique score combinations: " + uniqueScores.size());
        for (String score : uniqueScores) {
            System.out.println(score);
        }
        for (int i = 0; i < NUM_TEAMS; i++) {
            for (int j = i + 1 ; j < NUM_TEAMS; j++) {

            }
        }
    }

    private static List<int[]> generateMatches() {
        int totalResults = (int) Math.pow(3, 10);
        List<int[]> matches = new ArrayList<>();
        for (int i = 0; i < totalResults; i++) {
            int[] result = new int[10];
            int temp = i;
            for (int j = 0; j < 10; j++) {
                result[j] = temp % 3;
                temp /= 3;
            }
            matches.add(result);
        }
        return matches;
    }
}
