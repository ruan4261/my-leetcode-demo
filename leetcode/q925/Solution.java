package demo.leetcode.q925;

public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        final int len = name.length();
        final int inLen = typed.length();
        int idx = 0;
        int inIdx = 0;

        while (idx < len) {
            char c = name.charAt(idx);
            int count = 0;
            while (idx < len && c == name.charAt(idx)) {
                count++;
                idx++;
            }

            if (inIdx >= inLen) return false;
            int limit = inIdx + count;
            for (; inIdx < limit; inIdx++) {
                if (inIdx >= inLen) return false;
                if (typed.charAt(inIdx) != c) return false;
            }
            while (inIdx < inLen && c == typed.charAt(inIdx)) {
                inIdx++;
            }
        }

        return inIdx == inLen;
    }

}
