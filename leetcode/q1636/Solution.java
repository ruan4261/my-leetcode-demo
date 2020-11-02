package demo.leetcode.q1636;

import java.util.Arrays;

public class Solution {
    public int[] frequencySort(int[] nums) {
        int len = nums.length;
        int[][] count = new int[201][2];

        for (int num : nums) {
            int i = num + 100;
            count[i][0]++;
            count[i][1] = num;
        }

        Arrays.sort(count, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int[] ans = new int[len];
        int idx = 0;
        for (int[] ints : count) {
            if (ints[0] == 0) continue;

            int theCount = ints[0];
            for (int j = 0; j < theCount; j++) {
                ans[idx++] = ints[1];
            }
        }

        return ans;
    }
}
