package demo.leetcode.q16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        if (target <= nums[0] + nums[1] + nums[2]) return nums[0] + nums[1] + nums[2];
        else if (target >= nums[len - 1] + nums[len - 2] + nums[len - 3])
            return nums[len - 1] + nums[len - 2] + nums[len - 3];


        int rec = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0, l = len - 2; i < l; i++) {
            int tar = target - nums[i];
            int head = i + 1, tail = len - 1;
            while (head < tail) {
                int curr = nums[head] + nums[tail];
                if (curr == tar) return target;

                int x = Math.abs(curr - tar);
                if (x < rec) {
                    rec = x;
                    ans = nums[i] + curr;
                }

                if (curr > tar) tail--;
                else head++;
            }
        }
        return ans;
    }

}
