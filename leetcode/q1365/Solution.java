package demo.leetcode.q1365;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int len = nums.length;
        int[][] local = new int[len][2];
        for (int i = 0; i < len; i++) {
            local[i][0] = nums[i];
            local[i][1] = i;
        }

        Arrays.sort(local, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[len];

        int count = 0;
        int prev = local[0][0];
        for (int i = 1; i < len; i++) {
            int curr = local[i][0];
            if (curr != prev) {
                count = i;
                prev = curr;
            }

            ans[local[i][1]] = count;
        }

        return ans;
    }

}
