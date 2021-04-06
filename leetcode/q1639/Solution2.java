package demo.leetcode.q1639;

public class Solution2 {

    /**
     * dynamic programming
     * dp[i][j]表示使用前i个字符组成目标j个长度的方案数
     */
    public int numWays(String[] words, String target) {
        int lw = words[0].length();
        int lt = target.length();
        long[][] dp = new long[lw + 1][lt + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= lw; i++) {
            int[] count = new int[26];
            for (String s : words) count[s.charAt(i - 1) - 'a']++;

            dp[i][0] = 1;
            for (int j = 1; j <= i && j <= lt; j++)
                dp[i][j] = (long) ((dp[i - 1][j] + dp[i - 1][j - 1] * count[target.charAt(j - 1) - 'a']) % (1e9 + 7));
        }

        return (int) dp[lw][lt];
    }
}
