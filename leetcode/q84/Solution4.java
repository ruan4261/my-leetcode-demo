package demo.leetcode.q84;

public class Solution4 {

    /**
     * 递归，以区间内最低高度再划分区间
     * 0ms
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        return getLargestRectangleArea(heights, 0, heights.length);
    }

    public int getLargestRectangleArea(int[] heights, int left, int right) {
        if (left == right) return 0;
        if (left == right - 1)
            return heights[left];

        boolean sorted = true;
        int shortestIndex = left;
        for (int i = left + 1; i < right; ++i) {
            if (heights[i] < heights[i - 1]) sorted = false;
            if (heights[shortestIndex] > heights[i]) shortestIndex = i;
        }

        if (sorted) {
            int max = 0;
            for (int i = left; i < right; i++) {
                int now = heights[i] * (right - i);
                max = Math.max(now, max);
            }
            return max;
        }

        int leftArea = getLargestRectangleArea(heights, left, shortestIndex);
        int rightArea = getLargestRectangleArea(heights, shortestIndex + 1, right);
        return Math.max(Math.max(leftArea, rightArea), (right - left) * heights[shortestIndex]);
    }

}
