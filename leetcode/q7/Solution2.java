package com.ruan.alg.leetcode.leetcode.q7;

public class Solution2 {

    /**
     * 进制位互换
     * 对10取余，将其作为结果的高位
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

}
