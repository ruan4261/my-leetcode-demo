package demo.leetcode.q120;

import java.util.List;

/**
 * 倒推
 */
public class Solution2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int floor = triangle.size();
        if (floor == 0) return 0;
        if (floor == 1) return triangle.get(0).get(0);
        int[] dp = new int[floor];
        for (int i = 0; i < floor; i++) {
            dp[i] = triangle.get(floor - 1).get(i);
        }

        for (int i = floor - 2; i >= 0; i--) {
            List<Integer> lv = triangle.get(i);
            int len = lv.size();
            for (int j = 0; j < len; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + lv.get(j);
            }
        }

        return dp[0];
    }

}
