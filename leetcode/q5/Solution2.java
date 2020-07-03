package demo.leetcode.q5;

/**
 * try dp
 */
public class Solution2 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[j] != chars[i]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
