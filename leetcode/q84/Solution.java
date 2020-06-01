package com.ruan.alg.leetcode.leetcode.q84;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * 【图莓了】
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * 【图莓了】
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 暴力1
     * O(mn)时间
     * O(1)空间
     * m为最高矩形，遇到MAX_INT这种直接爆炸
     * no ac
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int max = 1;
        int ans = 0;
        int temp = 0;
        for (int j = 1; j <= max; j++) {
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] > max) max = heights[i];
                if (heights[i] < j) {
                    if (temp > ans) ans = temp;
                    temp = 0;
                } else {
                    temp += j;
                }
            }
            if (temp > ans) ans = temp;
            temp = 0;
        }
        return ans;
    }

}
