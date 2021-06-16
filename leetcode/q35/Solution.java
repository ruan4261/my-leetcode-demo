package demo.leetcode.q35;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] < target) return right + 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int val = nums[mid];

            if (target == val) return mid;
            else if (target < val) {
                right = mid;
            } else {// target > val
                left = mid + 1;
            }
        }
        return left;
    }

}
