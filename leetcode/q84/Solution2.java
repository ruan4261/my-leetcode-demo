package demo.leetcode.q84;

public class Solution2 {

    /**
     * 暴力2
     * O(n^2)时间
     * O(1)空间
     * no ac
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int ans = 0;
        for (int i = 1; i <= heights.length; i++) {

            for (int j = 0; j <= heights.length - i; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    if (heights[k] < min) min = heights[k];
                }
                int res = min * i;
                if (res > ans) ans = res;
            }
        }
        return ans;
    }

}
