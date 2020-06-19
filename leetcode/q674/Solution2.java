package com.ruan.alg.leetcode.leetcode.q674;

/**
 * 分区间计算该区间最长可选子段
 * 子段长度达到区间一半则必是该区间最长子段
 */
public class Solution2 {

    public static int findLengthOfLCIS(int[] nums) {
        return longestSub(nums, 0, nums.length - 1);
    }

    /**
     * map-reduce原理
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int longestSub(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }

        int mid = (l + r) / 2;
        int across = across(nums, l, r);
        if (across > mid - l) {
            return across;
        }
        return Math.max(Math.max(longestSub(nums, l, mid - 1), longestSub(nums, mid + 1, r)), across);
    }

    private static int across(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        int i = mid;
        int j = mid;
        while (i > l && nums[i - 1] < nums[i]) {
            i--;
        }
        while (j < r && nums[j + 1] > nums[j]) {
            j++;
        }
        return j - i + 1;
    }

}
