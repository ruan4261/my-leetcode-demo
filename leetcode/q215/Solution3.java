package com.ruan.alg.leetcode.leetcode.q215;

/**
 * 单轴单边快排，有意思
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) return nums[l];
        int i = l - 1, j = r + 1;
        int x = nums[l + r >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }
        if (r - j >= k) return quickSort(nums, j + 1, r, k);
        return quickSort(nums, l, j, k - (r - j));
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
