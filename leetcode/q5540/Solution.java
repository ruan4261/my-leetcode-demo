package demo.leetcode.q5540;

import java.util.Arrays;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int len = points.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = points[i][0];
        }

        Arrays.sort(a);
        int max = 0;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, a[i] - a[i - 1]);
        }

        return max;
    }
}
