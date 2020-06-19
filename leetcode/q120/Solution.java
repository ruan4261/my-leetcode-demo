package com.ruan.alg.leetcode.leetcode.q120;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int floor = triangle.size();
        int[][] dp = new int[floor][];
        for (int i = 0; i < floor; i++) {
            dp[i] = new int[i + 1];
        }
        dp[0][0] = triangle.get(0).get(0);

        for (int j = 1; j < floor; j++) {
            for (int i = 0; i < dp[j].length; i++) {
                int v = triangle.get(j).get(i);
                int add = Integer.MAX_VALUE;
                if (i > 0) {
                    add = dp[j - 1][i - 1];
                }
                if (i < dp[j].length - 1) {
                    add = Math.min(add, dp[j - 1][i]);
                }
                dp[j][i] = v + add;
            }
        }

        int[] res = dp[floor - 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < floor; i++) {
            if (res[i] < ans) ans = res[i];
        }
        return ans;
    }

}
