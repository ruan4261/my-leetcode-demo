package demo.leetcode.q1814;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    final int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> diffs = new HashMap<>();
        for (int n : nums) {
            int diff = n - rev(n);
            diffs.merge(diff, 1, Integer::sum);
        }

        long res = 0;
        for (int n : diffs.values()) {
            res += (((long) n * n - n) >> 1) % MOD;
        }
        return (int) res;
    }

    public int rev(int x) {
        int res = 0;
        while (x > 0) {
            int mod = x % 10;
            x /= 10;
            res = res * 10 + mod;
        }
        return res;
    }

}
