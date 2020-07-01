package com.ruan.alg.leetcode.leetcode.q4;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1, len2;
        if (nums1 == null || (len1 = nums1.length) == 0) {
            len2 = nums2.length;
            if ((len2 & 1) == 1) return nums2[len2 >> 1];
            else return (nums2[len2 >> 1] + nums2[(len2 >> 1) - 1]) / 2.0;
        } else if (nums2 == null || (len2 = nums2.length) == 0) {
            if ((len1 & 1) == 1) return nums1[len1 >> 1];
            else return (nums1[len1 >> 1] + nums1[(len1 >> 1) - 1]) / 2.0;
        }
        int len = len1 + len2;
        boolean even = (len & 1) == 0;
        int idx1 = 0;
        int idx2 = 0;
        int ans = 0;
        for (int i = 0, l = len >> 1; i <= l; i++) {
            int curr;
            if (idx1 >= len1) {
                curr = nums2[idx2++];
            } else if (idx2 >= len2) {
                curr = nums1[idx1++];
            } else {
                curr = nums1[idx1] <= nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
            }
            if (i == l || (even && i == l - 1)) ans += curr;
        }
        return even ? ans / 2.0 : ans;
    }

}
