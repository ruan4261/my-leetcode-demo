package com.ruan.alg.leetcode.q45;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 时间最好为O(1)最差为O(n)
     * 空间O(1)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;// 当前步数
        int curr = 0;// 当前下标

        outer:
        while (curr < nums.length - 1) {
            ++step;
            int currMax = curr + nums[curr];// 当前元素能达到的最远下标
            int nextMax = 0;// 记录值：两次跳跃可达到的最远下标

            for (int i = curr; i <= currMax; ++i) {
                if (i >= nums.length - 1) break outer;
                if (i + nums[i] > nextMax) {
                    nextMax = i + nums[i];
                    curr = i;
                }
            }
        }
        return step;
    }

}
