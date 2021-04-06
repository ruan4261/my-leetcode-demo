package demo.leetcode.q674;

/**
 * 674. 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *  
 * <p>
 * 注意：数组长度不会超过10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        int tempLink = 1;
        int prev = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > prev) tempLink = tempLink + 1;
            else {
                ans = Math.max(ans, tempLink);
                tempLink = 1;
            }
            prev = n;
        }
        return Math.max(ans, tempLink);
    }

}
