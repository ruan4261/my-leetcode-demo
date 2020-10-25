package demo.leetcode.q982;

public class Solution {

    public int countTriplets(int[] A) {
        int ans = 0;
        final int len = A.length;
        final int max = max(A);
        final int bitHigh = max == 0 ? 1 : Integer.highestOneBit(max) << 1;
        final int mask = bitHigh - 1;
        final int[] countMap = new int[bitHigh];

        for (int i : A) {
            for (int j : A) {
                ++countMap[i & j];
            }
        }

        for (int k : A) {
            if (k == 0) {
                ans += len * len;
                continue;
            }

            k ^= mask;

            for (int i = k; i > 0; i = (i - 1) & k)
                ans += countMap[i];
            ans += countMap[0];
        }

        return ans;
    }

    public int max(int[] a) {
        if (a == null || a.length == 0) return 0;
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }
}
