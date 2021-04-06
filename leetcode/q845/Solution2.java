package demo.leetcode.q845;

public class Solution2 {

    public int longestMountain(int[] A) {
        int ans = 0;

        for (int i = 0; i < A.length - 2; ) {
            while (i < A.length - 1 && A[i] >= A[i + 1]) i++;
            int left = i;

            // 找上坡
            while (i < A.length - 1 && A[i] < A[i + 1]) i++;
            int leftLen = i - left;

            // 找下坡
            while (i < A.length - 1 && A[i] > A[i + 1]) i++;

            int len = i - left;
            if (leftLen > 0 && len > leftLen) ans = Math.max(ans, len + 1);
        }

        return ans;
    }

}
