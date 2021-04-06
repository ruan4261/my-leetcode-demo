package demo.leetcode.q69;

/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * ???
     * 好像没必要
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 设置floor为可能的最小值，ceil为可能最大值，不断缩小区间
     *
     * @param x
     * @return
     */
    public int sqrt(int x) {
        long floor = 0;
        long ceil = (x >> 1) + 1;

        while (floor < ceil) {
            // 区间中位值（偶数取大）
            long mid = (floor + ceil + 1) >> 1;
            long square = mid * mid;

            // 如果中位值平方与x对比，缩小区间范围
            // 直到区间最小值与最大值相遇
            if (square > x) {
                ceil = mid - 1;
            } else {
                floor = mid;
            }
        }

        return (int) floor;
    }
}
