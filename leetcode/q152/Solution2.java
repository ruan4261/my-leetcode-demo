package demo.leetcode.q152;

public class Solution2 {

    public int maxProduct(int[] nums) {
        int ans = nums[0];

        int temp = 1;
        for (int num : nums) {
            temp = temp * num;
            if (ans < temp) ans = temp;
            if (num == 0) temp = 1;
        }

        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp = temp * nums[i];
            if (ans < temp) ans = temp;
            if (nums[i] == 0) temp = 1;
        }

        return ans;
    }

}
