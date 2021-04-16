package demo.leetcode.lcp28;

import java.util.Arrays;

public class Solution {

    final int MOD = (int) (1e9 + 7);

    public int purchasePlans(int[] nums, int target) {
        long ans = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (right > 0 && nums[right] >= target) right--;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                ans += right - left;
                left++;
            } else right--;
            ans %= MOD;
        }

        return (int) ans % MOD;
    }

}
