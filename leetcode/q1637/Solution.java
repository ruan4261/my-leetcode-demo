package demo.leetcode.q1637;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int len = points.length;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        for (int i = 1; i < len; i++)
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);


        return ans;
    }
}