package com.ruan.alg.leetcode.leetcode.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0, l = len - 2; i < l; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int head = i + 1, tail = len - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    if (nums[head] == nums[tail]) break;
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                    head++;
                    tail--;
                } else if (sum > 0) {
                    while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                    tail--;
                } else {// sum < 0
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    head++;
                }
            }
        }
        return ans;
    }

}
