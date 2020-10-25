package demo.leetcode.q845;

public class Solution {

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;

        int ans = 0;
        int up = 0, low = 0;
        int prev = A[0];

        for (int i = 1; i < A.length; i++) {
            if (low > 0) {
                // 当前是下坡
                if (A[i] < prev) low++;
                else {
                    if (Math.min(up, low) > 0) ans = Math.max(ans, up + low + 1);
                    if (A[i] > prev) up = 1;
                    else up = 0;

                    low = 0;
                }
            } else {
                // 当前是上坡
                if (A[i] > prev) up++;
                else if (A[i] == prev) {
                    up = 0;
                } else {
                    low = 1;
                }
            }

            prev = A[i];
        }

        if (Math.min(up, low) > 0) ans = Math.max(ans, up + low + 1);
        return ans;
    }

}
