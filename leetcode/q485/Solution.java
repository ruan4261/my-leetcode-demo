package demo.leetcode.q485;

/**
 * 485. 最大连续1的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public int findMaxConsecutiveOnes0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = 0;
        int temp = 0;
        int idx = 0;
        while (idx < len) {
            if (nums[idx++] == 1) {
                temp++;
            } else {
                if (temp > ans) ans = temp;
                temp = 0;
            }
        }

        return Math.max(ans, temp);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = 0;
        int begin = -1;
        int idx = 0;
        while (idx < len) {
            if (nums[idx] == 0) {
                ans = Math.max(ans, (idx - begin - 1));
                begin = idx;
            }
            idx++;
        }

        return Math.max(ans, (idx - begin - 1));
    }
}
