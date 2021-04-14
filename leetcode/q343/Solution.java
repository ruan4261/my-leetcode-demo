package demo.leetcode.q343;

public class Solution {

    /**
     * 根据算术几何均值不等式推论出的答案见{@link demo.leetcode.offer14.Solution}
     */
    public int integerBreak(int n) {
        if (n < 4) return n - 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            int half = i >> 1;
            for (int j = 2; j <= half; j++) {
                int tmp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        return dp[n];
    }

}
