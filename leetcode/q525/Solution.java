package demo.leetcode.q525;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;

            Integer prevIndex = prefixSum.get(sum);
            if (prevIndex == null) {
                prefixSum.put(sum, i);
            } else {
                ans = Math.max(ans, i - prevIndex);
            }
        }
        return ans;
    }

}
