package demo.leetcode.q844;

public class Solution {

    public boolean backspaceCompare(String S, String T) {
        final int lenS = S.length();
        final int lenT = T.length();
        int idxS = lenS - 1;
        int idxT = lenT - 1;

        for (; ; ) {
            idxS = helper(idxS, S);
            idxT = helper(idxT, T);

            if (idxS < 0 && idxT < 0) return true;
            if (idxS < 0 || idxT < 0) return false;
            if (S.charAt(idxS) != T.charAt(idxT)) return false;

            idxS--;
            idxT--;
        }
    }

    /**
     * 返回前一个有效字符下标
     */
    private int helper(int idx, String s) {
        int skip = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                skip++;
                idx--;
            } else if (skip > 0) {
                skip--;
                idx--;
            } else break;
        }
        return idx;
    }

}
