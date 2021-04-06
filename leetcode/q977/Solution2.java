package demo.leetcode.q977;

public class Solution2 {

    public int[] sortedSquares(int[] A) {
        final int[] ans = new int[A.length];
        int l = 0, r = A.length - 1;
        int idx = r;

        while (l <= r) {
            int lN = Math.abs(A[l]);
            int rN = Math.abs(A[r]);
            if (lN > rN) {
                ans[idx--] = lN * lN;
                l++;
            } else {
                ans[idx--] = rN * rN;
                r--;
            }
        }

        return ans;
    }
}
