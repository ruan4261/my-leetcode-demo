package demo.leetcode.offer14;

public class Solution {

    /**
     * dp解法见{@link demo.leetcode.q343.Solution}
     */
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int remainder = n % 3;
        return remainder == 0 ? binaryPow(3, n / 3) :
                remainder == 1 ? binaryPow(3, (n / 3) - 1) * 4 :
                        // remainder == 2
                        binaryPow(3, n / 3) * 2;
    }

    int binaryPow(int base, int exponent) {
        int res = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) res *= base;
            base *= base;
            exponent >>= 1;
        }
        return res;
    }

}
