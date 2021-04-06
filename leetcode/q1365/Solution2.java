package demo.leetcode.q1365;

public class Solution2 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] bucket = new int[101];

        for (int n : nums)
            bucket[n]++;

        for (int i = 1; i < bucket.length; i++)
            bucket[i] += bucket[i - 1];

        for (int i = 0; i < len; i++)
            if (nums[i] > 0) ans[i] = bucket[nums[i] - 1];

        return ans;
    }

}
