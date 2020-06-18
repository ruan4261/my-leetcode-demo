package com.ruan.alg.leetcode.leetcode.iv0805;

/**
 * @author ruan4261
 */
public class Solution2 {
    /**
     * 使用递归
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        return helper(max, min);
    }

    public int helper(int A, int B) {
        return B == 0 ? 0 : ((helper(A, B >> 1) << 1) + ((B & 1) == 1 ? A : 0));
    }
}
