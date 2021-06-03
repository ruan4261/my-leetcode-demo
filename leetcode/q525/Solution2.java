package demo.leetcode.q525;

import java.util.Arrays;

public class Solution2 {

    /**
     * hash定向优化
     */
    public int findMaxLength(int[] nums) {
        int min, max = min = 0;
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            f += nums[i];
            min = Math.min(min, f);
            max = Math.max(max, f);
        }
        int[] mapper = new int[max - min + 1];
        Arrays.fill(mapper, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0)
                ans = i + 1;

            int prevIndex = mapper[sum - min];
            if (prevIndex == -1)
                mapper[sum - min] = i;
            else
                ans = Math.max(ans, i - prevIndex);
        }
        return ans;
    }

}
