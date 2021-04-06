package demo.leetcode.q925;

public class Solution2 {

    public boolean isLongPressedName(String name, String typed) {
        final int len = name.length();
        final int inLen = typed.length();
        if (len > inLen) return false;

        int i = 0, j = 0;
        while (i < len && j < inLen) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        while (j < inLen) {
            if (typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return i == len;
    }

}
