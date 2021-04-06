package demo.leetcode.q26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        int prev = nums[0];
        for (int n : nums) {
            if (prev != n) {
                nums[ans++] = n;
                prev = n;
            }
        }
        return ans;
    }
}
