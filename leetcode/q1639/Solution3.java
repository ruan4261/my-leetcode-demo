package demo.leetcode.q1639;

public class Solution3 {

    final static int MOD = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int lw = words[0].length();
        int lt = target.length();
        int[][] count = new int[lw][26];
        long[] dp = new long[lw];

        for (String w : words)
            for (int i = 0; i < lw; i++)
                count[i][w.charAt(i) - 'a']++;

        int first = target.charAt(0) - 'a';
        for (int j = 0; j <= lw - lt; ++j) {
            dp[j] = count[j][first];
            if (j > 0) dp[j] += dp[j - 1];
        }

        for (int i = 1; i < lt; ++i) {
            int ch = target.charAt(i) - 'a';
            for (int j = lw - (lt - i); j >= i; j--) {
                dp[j] = dp[j - 1] * count[j][ch];
                dp[j] %= MOD;
            }

            for (int j = i + 1; j <= lw - (lt - i); j++) {
                dp[j] += dp[j - 1];
                dp[j] %= MOD;
            }
        }

        return (int) dp[lw - 1];
    }

}
