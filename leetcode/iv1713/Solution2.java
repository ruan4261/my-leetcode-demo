package demo.leetcode.iv1713;

import java.util.*;

public class Solution2 {
    private int[] dp;

    public int respace(String[] dictionary, String sentence) {
        if (sentence.length() == 0) return 0;

        Map<Character, List<String>> map = new HashMap<>();
        for (String str : dictionary) {
            List<String> list = map.get(str.charAt(0));
            if (list == null) list = new LinkedList<>();
            list.add(str);
            map.put(str.charAt(0), list);
        }

        dp = new int[sentence.length()];
        dp(map, sentence, 0);
        return dp[0] - 1;
    }

    private int dp(Map<Character, List<String>> map, String sentence, int start) {
        if (start == sentence.length()) return 0;
        if (dp[start] > 0) return dp[start] - 1;

        int ans = sentence.length() - start;
        if (map.containsKey(sentence.charAt(start))) {
            List<String> list = map.get(sentence.charAt(start));
            for (String l : list) {
                if (sentence.startsWith(l, start)) {
                    ans = Math.min(ans, dp(map, sentence, start + l.length()));
                }
            }
        }
        ans = Math.min(ans, dp(map, sentence, start + 1) + 1);

        dp[start] = ans + 1;
        return ans;
    }
}
