package demo.leetcode.q209;

public class Solution2 {

    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int head = 0;
        int tail = 0;
        int sum = 0;
        while (head < nums.length) {
            sum += nums[head++];
            while (sum >= s) {
                ans = Math.min(ans, head - tail);
                sum -= nums[tail++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
