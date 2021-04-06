package demo.leetcode.q844;

public class Solution2 {

    public boolean backspaceCompare(String S, String T) {
        final char[] arrS = S.toCharArray();
        int idxS = 0;
        for (char c : arrS) {
            if (c == '#') {
                if (idxS > 0) idxS--;
            } else {
                arrS[idxS++] = c;
            }
        }

        final char[] arrT = T.toCharArray();
        int idxT = 0;
        for (char c : arrT) {
            if (c == '#') {
                if (idxT > 0) idxT--;
            } else {
                arrT[idxT++] = c;
            }
        }

        if (idxS != idxT) return false;
        for (int i = 0; i < idxS; i++) {
            if (arrS[i] != arrT[i]) return false;
        }

        return true;
    }

}
