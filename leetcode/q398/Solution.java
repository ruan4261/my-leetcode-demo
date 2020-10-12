package demo.leetcode.q398;

import java.util.Random;

class Solution {

    private final Random random;
    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int len = nums.length;
        int count = 0, ans = 0;

        for (int i = 0; i < len; i++) {
            if (this.nums[i] == target) {
                if (random.nextInt(++count) == 0) {
                    ans = i;
                }
            }
        }

        return ans;
    }

}
