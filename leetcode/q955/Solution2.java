package demo.leetcode.q955;

public class Solution2 {

    /**
     * 居然和我写的是一个意思
     * 我觉得我写的好懂一些
     *
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int N = A.length;
        int W = A[0].length();
        boolean[] cuts = new boolean[N - 1];

        int ans = 0;
        search:
        for (int j = 0; j < W; ++j) {
            for (int i = 0; i < N - 1; ++i)
                if (!cuts[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    ans++;
                    continue search;
                }

            for (int i = 0; i < N - 1; ++i)
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    cuts[i] = true;
        }

        return ans;
    }

}
