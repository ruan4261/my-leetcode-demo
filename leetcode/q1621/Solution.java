package demo.leetcode.q1621;

import java.math.BigInteger;

public class Solution {

    private final static BigInteger MOD = BigInteger.valueOf((int) 1e9 + 7);

    public int numberOfSets(int n, int k) {
        return this.comb(n + k - 1, 2 * k);
    }

    public int comb(int n, int m) {
        BigInteger res = BigInteger.ONE;
        int i = 0;
        while ((++i) <= m)
            res = res.multiply(BigInteger.valueOf(n--)).divide(BigInteger.valueOf(i));

        return res.divideAndRemainder(MOD)[1].intValue();
    }
}
